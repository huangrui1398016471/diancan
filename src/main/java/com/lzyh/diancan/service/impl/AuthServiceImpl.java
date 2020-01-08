package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.Auth;
import com.lzyh.diancan.dao.AuthDao;
import com.lzyh.diancan.service.AuthService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthDao, Auth> implements AuthService {

}
