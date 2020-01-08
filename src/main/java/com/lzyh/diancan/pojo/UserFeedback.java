package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户反馈表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@TableName("of_user_feedback")
public class UserFeedback extends Model<UserFeedback> {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商家ID
     */
    private Integer merchantId;
    /**
     * 反馈信息
     */
    private String feedbackInfo;
    /**
     * 反馈时间
     */
    private Date feedbackTime;
    /**
     * 是否处理:0:未处理,1:正在处理,2:处理完成
     */
    private Integer isHandle;


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

    public String getFeedbackInfo() {
        return feedbackInfo;
    }

    public void setFeedbackInfo(String feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserFeedback{" +
        ", id=" + id +
        ", merchantId=" + merchantId +
        ", feedbackInfo=" + feedbackInfo +
        ", feedbackTime=" + feedbackTime +
        ", isHandle=" + isHandle +
        "}";
    }
}
