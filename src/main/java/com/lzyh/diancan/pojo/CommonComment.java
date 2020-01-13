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
 * 顾客评论表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_common_comment")
public class CommonComment extends Model<CommonComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 顾客评论ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 顾客信息ID
     */
    private Long customerInfoId;
    /**
     * 商家评分
     */
    private BigDecimal score;
    /**
     * 评论内容
     */
    private String commentInfo;
    /**
     * 评论时间
     */
    private Date commentTime;
    /**
     * 审核状态:0:,已审核,1:未审核,2:审核未通过
     */
    private Integer auditState;


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

    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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
        return "CommonComment{" +
        ", id=" + id +
        ", orderId=" + orderId +
        ", customerInfoId=" + customerInfoId +
        ", score=" + score +
        ", commentInfo=" + commentInfo +
        ", commentTime=" + commentTime +
        ", auditState=" + auditState +
        "}";
    }
}
