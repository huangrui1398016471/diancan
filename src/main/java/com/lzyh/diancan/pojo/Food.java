package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜品表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@TableName("of_food")
public class Food extends Model<Food> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜品分类ID
     */
    private Integer foodTypeId;
    /**
     * 商家ID
     */
    private Integer merchantId;
    /**
     * 菜品名称
     */
    private String foodName;
    /**
     * 描述
     */
    private String info;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 折扣价
     */
    private BigDecimal discountPrice;
    /**
     * 图片URL
     */
    private String img;
    /**
     * 上下架状态:0:上架,1:下架
     */
    private Integer udState;
    /**
     * 是否有规格:0:有,1:无
     */
    private Integer isSpecs;
    /**
     * 0:,已审核,1:未审核
     */
    private Integer auditState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUdState() {
        return udState;
    }

    public void setUdState(Integer udState) {
        this.udState = udState;
    }

    public Integer getIsSpecs() {
        return isSpecs;
    }

    public void setIsSpecs(Integer isSpecs) {
        this.isSpecs = isSpecs;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Food{" +
        ", id=" + id +
        ", foodTypeId=" + foodTypeId +
        ", merchantId=" + merchantId +
        ", foodName=" + foodName +
        ", info=" + info +
        ", price=" + price +
        ", discountPrice=" + discountPrice +
        ", img=" + img +
        ", udState=" + udState +
        ", isSpecs=" + isSpecs +
        ", auditState=" + auditState +
        "}";
    }
}
