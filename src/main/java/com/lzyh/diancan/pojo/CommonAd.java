package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 广告表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_common_ad")
public class CommonAd extends Model<CommonAd> {

    private static final long serialVersionUID = 1L;

    /**
     * 广告ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String describeInfo;
    /**
     * 图片URL
     */
    private String photoUrl;
    /**
     * 跳转URL
     */
    private String hrefUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommonAd{" +
        ", id=" + id +
        ", title=" + title +
        ", describeInfo=" + describeInfo +
        ", photoUrl=" + photoUrl +
        ", hrefUrl=" + hrefUrl +
        "}";
    }
}
