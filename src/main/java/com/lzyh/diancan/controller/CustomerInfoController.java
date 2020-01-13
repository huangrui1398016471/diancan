package com.lzyh.diancan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzyh.diancan.model.common.Constant;
import com.lzyh.diancan.model.common.ResponseBean;
import com.lzyh.diancan.pojo.CustomerInfo;
import com.lzyh.diancan.service.impl.CustomerInfoServiceImpl;
import com.lzyh.diancan.utils.JedisUtil;
import com.lzyh.diancan.utils.JwtUtil;
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
 * 顾客信息表 前端控制器
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@RestController
@RequestMapping("/customerInfo")
@PropertySource("classpath:config.properties")
public class CustomerInfoController {

    //    获取过期时间
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;
    //    private final UserUtil userUtil;
    private final CustomerInfoServiceImpl cusInfoService;
    @Autowired
    public CustomerInfoController( CustomerInfoServiceImpl cusInfoService) {
//        this.userUtil = userUtil;
        this.cusInfoService = cusInfoService;
    }

    /**
     * 微信登录授权
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author huangrui
     * @date 2018/8/30 16:21
     */
    @PostMapping("/weixinLogin")
    public ResponseBean weixinLogin(@RequestParam(name="openid") String openid, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息

//        User userDto = new User();
        CustomerInfo custom = new CustomerInfo();
        custom.setOpenId(openid);

//        User userTemp = new User();
//        userTemp.setUserName(user.getUserName());
        EntityWrapper<CustomerInfo> cusWrapper = new EntityWrapper<>();
        cusWrapper.setEntity(custom);
        custom = cusInfoService.selectOne(cusWrapper);
        System.out.println("传回custoninfo查询结果:"+custom);
//        当前用户存在，登录成功返回token，当前用户不存在，保存openid，生成token返回
        if (custom == null) {
//            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
            custom = new CustomerInfo();
            custom.setOpenId(openid);
            boolean insert = cusInfoService.insert(custom);
            if(insert){
                System.out.println("新增成功");
            }
            System.out.println("新增openid然后返回token");
            System.out.println("新增结果:"+custom);
        }
        System.out.println("----");
        // 清除可能存在的Shiro权限信息缓存
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + custom.getOpenId())) {
            JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + custom.getOpenId());
        }
        // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        System.out.println("----");
        JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + custom.getOpenId(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String token = JwtUtil.sign(custom.getOpenId(), currentTimeMillis);
        httpServletResponse.setHeader("Authorization", token);
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
        return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
    }
}

