package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.Food;
import com.lzyh.diancan.dao.FoodDao;
import com.lzyh.diancan.service.FoodService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodDao, Food> implements FoodService {

}
