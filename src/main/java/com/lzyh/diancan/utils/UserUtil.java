package com.lzyh.diancan.utils;

import com.lzyh.diancan.dao.SysUserDao;
import com.lzyh.diancan.exception.CustomException;
import com.lzyh.diancan.model.common.Constant;
import com.lzyh.diancan.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取当前登录用户工具类
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/3/15 11:45
 */
@Component
public class UserUtil {


    private SysUserDao userDao;

    @Autowired
    public UserUtil(SysUserDao userDao) {
        this.userDao = userDao;
    }

/**
 * 功能描述: <br>
 * 〈获取当前登录用户〉
 * @Param: []
 * @Return: com.lzyh.diancan.pojo.User
 * @Author: 13980
 * @Date: 2020/1/9 10:54
 */

    public SysUser getUser() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得Account
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
        SysUser user = new SysUser();
        user.setUserName(account);
        SysUser user3 = userDao.selectOne(user);
        // 用户是否存在
        if (user3 == null) {
            throw new CustomException("该帐号不存在(The account does not exist.)");
        }
        return user3;
    }

    /**
     * 获取当前登录用户Id
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public Long getUserId() {
        return getUser().getId();
    }

    /**
     * 获取当前登录用户Token
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public String getToken() {
        return SecurityUtils.getSubject().getPrincipal().toString();
    }

    /**
     * 获取当前登录用户Account
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public String getAccount() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得Account
        return JwtUtil.getClaim(token, Constant.ACCOUNT);
    }
}
