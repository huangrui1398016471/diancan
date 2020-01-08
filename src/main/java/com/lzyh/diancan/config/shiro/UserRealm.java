package com.lzyh.diancan.config.shiro;


import com.lzyh.diancan.config.shiro.jwt.JwtToken;
import com.lzyh.diancan.dao.RoleDao;
import com.lzyh.diancan.dao.UserDao;
import com.lzyh.diancan.model.common.Constant;
import com.lzyh.diancan.pojo.User;
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


/**
 * 自定义Realm
 * @author dolyw.com
 * @date 2018/8/30 14:10
 */
@Service
public class UserRealm extends AuthorizingRealm {
    private RoleDao roleDao;
    private UserDao userDao;

    @Autowired
    public UserRealm(UserDao userDao1, RoleDao roleDao1) {
        this.userDao = userDao1;
        this.roleDao = roleDao1;
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
        String account = JwtUtil.getClaim(principalCollection.toString(), Constant.ACCOUNT);
        System.out.println("account:"+account);
//        用户名
//        User user = new User();
//        user.setUserName(account);
//        user = userDao.selectOne(user);
//        System.out.println(user);
        // 查询用户角色
//        List<RoleDto> roleDtos = roleMapper.findRoleByUser(userDto);
//        EntityWrapper<Role> roleMapper = new EntityWrapper<Role>();
//        roleMapper.setEntity(roleDao.selectById(user.getRoleId()));
//        List<Role> roleList = roleDao.selectList(roleMapper);
//        System.out.println("role list:-----"+roleList.toString());
//        for (Iterator<Role> iterator = roleList.iterator(); iterator.hasNext(); ) {
//            Role next =  iterator.next();
//             //添加角色
//            simpleAuthorizationInfo.addRole(next.getRole());
//            simpleAuthorizationInfo.addStringPermission("admin");
//        }
        System.out.println("角色："+simpleAuthorizationInfo);
//        User selectOne = userDao1.selectOne(user);
//        Role role = new Role();
//        role.setId(selectOne.getRoleId());
//        List<Role> roles = roleDao1.selectById(role);
//        for (RoleDto roleDto : roleDtos) {
//            if (roleDto != null) {
//                // 添加角色
//                simpleAuthorizationInfo.addRole(roleDto.getName());
//                // 根据用户角色查询权限
//                List<PermissionDto> permissionDtos = permissionMapper.findPermissionByRole(roleDto);
//                for (PermissionDto permissionDto : permissionDtos) {
//                    if (permissionDto != null) {
//                        // 添加权限
//                        simpleAuthorizationInfo.addStringPermission(permissionDto.getPerCode());
//                    }
//                }
//            }
//        }
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
        User user = new User();
        user.setUserName(account);
        User user1 = userDao.selectOne(user);
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
