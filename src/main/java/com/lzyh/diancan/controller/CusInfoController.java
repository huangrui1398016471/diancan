package com.lzyh.diancan.controller;
import com.lzyh.diancan.service.impl.CusInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 顾客信息表 前端控制器
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/custom")
@PropertySource("classpath:config.properties")
public class CusInfoController {

    //    获取过期时间
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;
//    private final UserUtil userUtil;
    private final CusInfoServiceImpl cusInfoService;
    @Autowired
    public CusInfoController( CusInfoServiceImpl cusInfoService) {
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
//    @PostMapping("/weixinLogin")
//    public ResponseBean weixinLogin(@RequestParam(name="openid") String openid, HttpServletResponse httpServletResponse) {
//        // 查询数据库中的帐号信息
//
////        User userDto = new User();
//        User user = new User();
//        user.setUserName(username);
//        user.setPassword(password);
//        User userTemp = new User();
//        userTemp.setUserName(user.getUserName());
//        EntityWrapper<User> wrapper = new EntityWrapper<>();
//        wrapper.setEntity(userTemp);
//        userTemp = userService.selectOne(wrapper);
//        if (userTemp == null) {
//            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
//        }
//        // 密码进行AES解密
//        String key = AesCipherUtil.deCrypto(userTemp.getPassword());
//        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
//        if (key.equals(user.getUserName() + user.getPassword())) {
//            // 清除可能存在的Shiro权限信息缓存
//            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + user.getUserName())) {
//                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + user.getUserName());
//            }
//            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
//            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
//            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + user.getUserName(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
//            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
//            String token = JwtUtil.sign(user.getUserName(), currentTimeMillis);
//            httpServletResponse.setHeader("Authorization", token);
//            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
//            return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
//        } else {
//            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
//        }
//    }

}

