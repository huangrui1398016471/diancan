package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.Order;
import com.lzyh.diancan.dao.OrderDao;
import com.lzyh.diancan.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}
