package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-10
 */
@TableName("of_sys_role_auth")
public class SysRoleAuth extends Model<SysRoleAuth> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long authId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRoleAuth{" +
        ", id=" + id +
        ", roleId=" + roleId +
        ", authId=" + authId +
        "}";
    }
}
