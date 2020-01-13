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
 * @since 2020-01-10
 */
@TableName("of_order_main")
public class OrderMain extends Model<OrderMain> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单主表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 商家ID
     */
    private Integer merchantId;
    /**
     * 订单金额
     */
    private BigDecimal orderPrice;
    /**
     * 是否支付,0:未支付,1:支付,2:已取消
     */
    private Integer isPay;
    /**
     * 顾客ID
     */
    private Integer customerId;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 用餐人数
     */
    private Integer peopleNum;
    /**
     * 支付方式(可能会更改)
     */
    private String payWay;
    /**
     * 订单类型;1:小程序到店订单2:公众号预约订单3:智能POS机到店订单
     */
    private Integer orderType;
    /**
     * 顾客备注
     */
    private String customerRemarks;
    /**
     * 预约时间(仅预约订单有)
     */
    private Date appointmentTime;
    /**
     * 顾客联系电话(仅预约订单有)
     */
    private String customerTel;
    /**
     * 桌号（仅小程序到店订单）
     */
    private Integer tableNum;
    /**
     * 叫餐号（仅智能POS机到店订单）
     */
    private String mealNum;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getCustomerRemarks() {
        return customerRemarks;
    }

    public void setCustomerRemarks(String customerRemarks) {
        this.customerRemarks = customerRemarks;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderMain{" +
        ", id=" + id +
        ", orderId=" + orderId +
        ", merchantId=" + merchantId +
        ", orderPrice=" + orderPrice +
        ", isPay=" + isPay +
        ", customerId=" + customerId +
        ", goodsNum=" + goodsNum +
        ", peopleNum=" + peopleNum +
        ", payWay=" + payWay +
        ", orderType=" + orderType +
        ", customerRemarks=" + customerRemarks +
        ", appointmentTime=" + appointmentTime +
        ", customerTel=" + customerTel +
        ", tableNum=" + tableNum +
        ", mealNum=" + mealNum +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
