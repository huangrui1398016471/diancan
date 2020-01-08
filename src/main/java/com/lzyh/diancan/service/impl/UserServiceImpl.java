package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.User;
import com.lzyh.diancan.dao.UserDao;
import com.lzyh.diancan.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
