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
 * 菜品规格表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_shop_food_spec")
public class ShopFoodSpec extends Model<ShopFoodSpec> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品规格ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜品ID
     */
    private Integer foodId;
    /**
     * 规格名称
     */
    private String specsName;
    /**
     * 价格
     */
    private BigDecimal price;
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

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return "ShopFoodSpec{" +
        ", id=" + id +
        ", foodId=" + foodId +
        ", specsName=" + specsName +
        ", price=" + price +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
