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
 * @since 2020-01-08
 */
@TableName("of_order_details")
public class OrderDetails extends Model<OrderDetails> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer orderId;
    private Integer foodId;
    private BigDecimal foodPrice;
    private Integer foodNum;
    private String foodSpecs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        return "OrderDetails{" +
        ", id=" + id +
        ", orderId=" + orderId +
        ", foodId=" + foodId +
        ", foodPrice=" + foodPrice +
        ", foodNum=" + foodNum +
        ", foodSpecs=" + foodSpecs +
        "}";
    }
}
