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
 * 商家信息表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_shop_merchant_info")
public class ShopMerchantInfo extends Model<ShopMerchantInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商家名称
     */
    private String merchantName;
    /**
     * 商家地址
     */
    private String merchantAddress;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 是否删除，0:未删除,1:已删除
     */
    private Integer isDelete;
    /**
     * 泸州银行卡卡号
     */
    private String lzBankCardNum;
    /**
     * 商户号
     */
    private String merchantNo;
    /**
     * 是否营业:0:打烊,1:营业
     */
    private Integer isOpen;
    /**
     * 负责人姓名
     */
    private String leaderName;
    /**
     * 负责人身份证号码
     */
    private String idCard;
    /**
     * 联系方式
     */
    private String telphone;
    /**
     * 商家评分
     */
    private BigDecimal score;
    /**
     * 评论人数
     */
    private Integer commentNum;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getLzBankCardNum() {
        return lzBankCardNum;
    }

    public void setLzBankCardNum(String lzBankCardNum) {
        this.lzBankCardNum = lzBankCardNum;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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
        return "ShopMerchantInfo{" +
        ", id=" + id +
        ", userId=" + userId +
        ", merchantName=" + merchantName +
        ", merchantAddress=" + merchantAddress +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", isDelete=" + isDelete +
        ", lzBankCardNum=" + lzBankCardNum +
        ", merchantNo=" + merchantNo +
        ", isOpen=" + isOpen +
        ", leaderName=" + leaderName +
        ", idCard=" + idCard +
        ", telphone=" + telphone +
        ", score=" + score +
        ", commentNum=" + commentNum +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
