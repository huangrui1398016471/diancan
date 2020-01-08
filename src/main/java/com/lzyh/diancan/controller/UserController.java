package com.lzyh.diancan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzyh.diancan.exception.CustomUnauthorizedException;
import com.lzyh.diancan.model.common.Constant;
import com.lzyh.diancan.model.common.ResponseBean;
import com.lzyh.diancan.pojo.User;
import com.lzyh.diancan.service.impl.UserServiceImpl;
import com.lzyh.diancan.utils.AesCipherUtil;
import com.lzyh.diancan.utils.JedisUtil;
import com.lzyh.diancan.utils.JwtUtil;
import com.lzyh.diancan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/user")
@PropertySource("classpath:config.properties")
public class UserController {
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

    private final UserUtil userUtil;

//    private final IUserService userService;

    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserUtil userUtil, UserServiceImpl userService) {
        this.userUtil = userUtil;
        this.userService = userService;
    }



    /**
     * 登录授权
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author dolyw.com
     * @date 2018/8/30 16:21
     */
    @PostMapping("/login")
    public ResponseBean login( @RequestParam(name="username") String username,
                               @RequestParam(name="password")String password, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息

//        User userDto = new User();
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        User userTemp = new User();
        userTemp.setUserName(user.getUserName());
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.setEntity(userTemp);
        userTemp = userService.selectOne(wrapper);
        if (userTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(user.getUserName() + user.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + user.getUserName())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + user.getUserName());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + user.getUserName(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(user.getUserName(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }

}

