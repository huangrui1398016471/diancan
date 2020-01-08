package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@TableName("of_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 商家ID
     */
    private Integer merchantId;
    /**
     * 订单金额
     */
    private BigDecimal orderMoney;
    /**
     * 0:未支付,1:支付
     */
    private Integer payState;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 顾客ID
     */
    private Integer cusId;
    /**
     * 商品数量
     */
    private Integer goodNum;
    /**
     * 用餐人数
     */
    private Integer peopleNum;
    /**
     * 支付方式
     */
    private String payWay;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 顾客备注
     */
    private String cusRemarks;
    /**
     * 预约时间
     */
    private Date orderTime;
    /**
     * 顾客联系电话
     */
    private String cusTel;
    /**
     * 桌号
     */
    private Integer tableNum;
    /**
     * 叫餐号
     */
    private String mealNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCusRemarks() {
        return cusRemarks;
    }

    public void setCusRemarks(String cusRemarks) {
        this.cusRemarks = cusRemarks;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public String getMealNum() {
        return mealNum;
    }

    public void setMealNum(String mealNum) {
        this.mealNum = mealNum;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Order{" +
        ", id=" + id +
        ", orderId=" + orderId +
        ", merchantId=" + merchantId +
        ", orderMoney=" + orderMoney +
        ", payState=" + payState +
        ", createTime=" + createTime +
        ", cusId=" + cusId +
        ", goodNum=" + goodNum +
        ", peopleNum=" + peopleNum +
        ", payWay=" + payWay +
        ", orderType=" + orderType +
        ", cusRemarks=" + cusRemarks +
        ", orderTime=" + orderTime +
        ", cusTel=" + cusTel +
        ", tableNum=" + tableNum +
        ", mealNum=" + mealNum +
        "}";
    }
}
