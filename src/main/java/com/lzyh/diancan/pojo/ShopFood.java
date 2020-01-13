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
 * 菜品表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_shop_food")
public class ShopFood extends Model<ShopFood> {

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
     * 描述信息
     */
    private String describeInfo;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 图片URL
     */
    private String imgUrl;
    /**
     * 是否上架:0:下架,1:上架
     */
    private Integer isUpper;
    /**
     * 是否有规格:0:无,1:有
     */
    private Integer isSpecs;
    /**
     * 审核状态，0:,未审核,1:审核通过,2:审核未通过
     */
    private Integer auditState;
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

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsUpper() {
        return isUpper;
    }

    public void setIsUpper(Integer isUpper) {
        this.isUpper = isUpper;
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
        return "ShopFood{" +
        ", id=" + id +
        ", foodTypeId=" + foodTypeId +
        ", merchantId=" + merchantId +
        ", foodName=" + foodName +
        ", describeInfo=" + describeInfo +
        ", price=" + price +
        ", imgUrl=" + imgUrl +
        ", isUpper=" + isUpper +
        ", isSpecs=" + isSpecs +
        ", auditState=" + auditState +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
