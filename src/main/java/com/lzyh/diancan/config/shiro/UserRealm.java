package com.lzyh.diancan.config.shiro;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzyh.diancan.config.shiro.jwt.JwtToken;

import com.lzyh.diancan.dao.*;
import com.lzyh.diancan.dto.RoleAuthDto;
import com.lzyh.diancan.dto.UserRoleDto;
import com.lzyh.diancan.model.common.Constant;

import com.lzyh.diancan.pojo.SysRole;
import com.lzyh.diancan.pojo.SysUser;
import com.lzyh.diancan.pojo.SysUserRole;
import com.lzyh.diancan.utils.JedisUtil;
import com.lzyh.diancan.utils.JwtUtil;
import com.lzyh.diancan.utils.common.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 自定义Realm
 * @author dolyw.com
 * @date 2018/8/30 14:10
 */
@Service
public class UserRealm extends AuthorizingRealm {
    private SysUserDao userDao;
    private UserRoleDao userRoleDao;
    private SysUserRoleDao sysUserRoleDao;
    private RoleAuthDao roleAuthDao;

    @Autowired
    public UserRealm(SysUserDao userDao,RoleAuthDao roleAuthDao,SysUserRoleDao sysUserRoleDao,UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.sysUserRoleDao = sysUserRoleDao;
        this.userRoleDao = userRoleDao;
        this.roleAuthDao = roleAuthDao;
    }

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     * 授权方法
     *
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("shiro:授权");
        String userName = JwtUtil.getClaim(principalCollection.toString(), Constant.ACCOUNT);
        /*
         *1.根据userName查询userId
         *2.根据userId查询用户角色联合表
         *3.根据roleId查询角色权限联合表
         *4.加入角色
         *5.加入权限
         */
        // 根据userName查询userId
        SysUser user = new SysUser();
        user.setUserName(userName);
        user = userDao.selectOne(user);
        // 根据userId查询用户角色联合表
        List<UserRoleDto> userRoleByUserId = userRoleDao.findUserRoleByUserId(user.getId());
        if(userRoleByUserId != null){
            for (int i = 0; i < userRoleByUserId.size(); i++) {
                UserRoleDto next = userRoleByUserId.get(i);
        // 加入角色
                simpleAuthorizationInfo.addRole(next.getRoleName());
        //  根据roleId查询角色权限联合表
                List<RoleAuthDto> authList = roleAuthDao.findRoleAuthDtoLisiByRoleId(next.getRoleId());
                if(authList != null){
                    for (int j = 0; j < authList.size(); j++) {
                        RoleAuthDto roleAuthNext = authList.get(j);
                        // 加入权限
                        simpleAuthorizationInfo.addStringPermission(roleAuthNext.getAuthCode());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     *
     * 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        System.out.println("shiro:登录,tocken:"+token);
        // 解密获得account，用于和数据库进行对比
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
        // 帐号为空
        if (StringUtil.isBlank(account)) {
            throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
        }
        // 查询用户是否存在
        SysUser user = new SysUser();
        user.setUserName(account);
        SysUser user1 = userDao.selectOne(user);
        if (user1 == null) {
            throw new AuthenticationException("该帐号不存在(The account does not exist.)");
        }
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
            // 获取RefreshToken的时间戳
            String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, "userRealm");
            }
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}
