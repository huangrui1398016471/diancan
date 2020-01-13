package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜品审核表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_shop_food_audit")
public class ShopFoodAudit extends Model<ShopFoodAudit> {

    private static final long serialVersionUID = 1L;

    /**
     * 审核ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商家ID
     */
    private Integer merchantId;
    /**
     * 菜品ID
     */
    private Integer foodId;
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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
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
        return "ShopFoodAudit{" +
        ", id=" + id +
        ", merchantId=" + merchantId +
        ", foodId=" + foodId +
        ", auditState=" + auditState +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
