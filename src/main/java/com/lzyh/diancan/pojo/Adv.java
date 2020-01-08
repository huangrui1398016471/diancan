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
 * @since 2020-01-08
 */
@TableName("of_adv")
public class Adv extends Model<Adv> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
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
    private String info;
    /**
     * 图片URL
     */
    private String photoUrl;
    /**
     * 跳转URL
     */
    private String reUrl;


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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getReUrl() {
        return reUrl;
    }

    public void setReUrl(String reUrl) {
        this.reUrl = reUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Adv{" +
        ", id=" + id +
        ", title=" + title +
        ", info=" + info +
        ", photoUrl=" + photoUrl +
        ", reUrl=" + reUrl +
        "}";
    }
}
