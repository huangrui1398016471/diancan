package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.CustomerInfo;
import com.lzyh.diancan.dao.CustomerInfoDao;
import com.lzyh.diancan.service.CustomerInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 顾客信息表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoDao, CustomerInfo> implements CustomerInfoService {

}
