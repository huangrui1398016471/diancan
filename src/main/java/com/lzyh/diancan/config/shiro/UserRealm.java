package com.lzyh.diancan.config.shiro;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzyh.diancan.config.shiro.jwt.JwtToken;

import com.lzyh.diancan.dao.SysRoleDao;
import com.lzyh.diancan.dao.SysUserDao;
import com.lzyh.diancan.dao.SysUserRoleDao;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 自定义Realm
 * @author dolyw.com
 * @date 2018/8/30 14:10
 */
@Service
public class UserRealm extends AuthorizingRealm {
    private SysRoleDao roleDao;
    private SysUserDao userDao;
    private SysUserRoleDao userRoleDao;

    @Autowired
    public UserRealm(SysUserDao userDao1, SysRoleDao roleDao1,SysUserRoleDao userRoleDao) {
        this.userDao = userDao1;
        this.roleDao = roleDao1;
        this.userRoleDao = userRoleDao;
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
         *2.根据userId查询roleId集合
         *3.根据roleId集合查询role集合 添加角色
         *4.根据roleId查询权限ID集合
         *5.根据权限id集合查询权限
         *6.添加权限
         */
        // 根据userName查询userId
        SysUser user = new SysUser();
        user.setUserName(userName);
        user = userDao.selectOne(user);
        // 根据userId查询roleId集合
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(user.getId());
        EntityWrapper<SysUserRole> userRoleMapper = new EntityWrapper<SysUserRole>();
        userRoleMapper.setEntity(sysUserRole);
        List<SysUserRole> roleList = userRoleDao.selectList(userRoleMapper);
        System.out.println("----------"+roleList);
        // roleId集合
        List list =new  ArrayList();
        if(roleList != null){
            for (int i = 0; i < roleList.size(); i++) {
                SysUserRole next = roleList.get(i);
                list.add(next.getRoleId());
            }
        }
        // 根据roleId集合查询role集合 加入鉴权器
        List<SysRole> sysRoles = roleDao.selectBatchIds(list);
        for (Iterator<SysRole> iterator = sysRoles.iterator(); iterator.hasNext(); ) {
            SysRole next = iterator.next();
            //添加角色(roleName)
            simpleAuthorizationInfo.addRole(next.getRoleName());
            //根据角色id查询权限id集合


            simpleAuthorizationInfo.addStringPermission("admin");
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
        System.out.println("---------------");
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
            // 获取RefreshToken的时间戳
            System.out.println("-------000");
            String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, "userRealm");
            }
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}
