package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商家信息表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@TableName("of_merchant_id")
public class MerchantId extends Model<MerchantId> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
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
     * 0:未删除,1:已删除
     */
    private Integer flag;
    /**
     * 泸州银行卡号
     */
    private String lzBankNum;
    /**
     * 商户号
     */
    private String merchantNo;
    /**
     * 状态:0:营业,1:打烊
     */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 负责人姓名
     */
    private String leaderName;
    /**
     * 负责人身份证号码
     */
    @TableField("Id_card")
    private String idCard;
    /**
     * 联系方式
     */
    private String telphone;
    /**
     * 分数
     */
    private BigDecimal score;
    /**
     * 评论人数
     */
    private Integer commentNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getLzBankNum() {
        return lzBankNum;
    }

    public void setLzBankNum(String lzBankNum) {
        this.lzBankNum = lzBankNum;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MerchantId{" +
        ", id=" + id +
        ", merchantName=" + merchantName +
        ", merchantAddress=" + merchantAddress +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", flag=" + flag +
        ", lzBankNum=" + lzBankNum +
        ", merchantNo=" + merchantNo +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", creater=" + creater +
        ", modifier=" + modifier +
        ", leaderName=" + leaderName +
        ", idCard=" + idCard +
        ", telphone=" + telphone +
        ", score=" + score +
        ", commentNum=" + commentNum +
        "}";
    }
}
