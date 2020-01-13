package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_order_detail")
public class OrderDetail extends Model<OrderDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单明细表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单主表ID
     */
    private Integer orderMainId;
    /**
     * 菜品ID
     */
    private Integer foodId;
    /**
     * 菜品价格
     */
    private BigDecimal foodPrice;
    /**
     * 菜品数量
     */
    private Integer foodNum;
    /**
     * 菜品规格名称
     */
    private String foodSpecs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Integer orderMainId) {
        this.orderMainId = orderMainId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public String getFoodSpecs() {
        return foodSpecs;
    }

    public void setFoodSpecs(String foodSpecs) {
        this.foodSpecs = foodSpecs;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
        ", id=" + id +
        ", orderMainId=" + orderMainId +
        ", foodId=" + foodId +
        ", foodPrice=" + foodPrice +
        ", foodNum=" + foodNum +
        ", foodSpecs=" + foodSpecs +
        "}";
    }
}
