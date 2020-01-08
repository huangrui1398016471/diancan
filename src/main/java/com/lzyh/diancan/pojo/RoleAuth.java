package com.lzyh.diancan.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@TableName("of_role_auth")
public class RoleAuth extends Model<RoleAuth> {

    private static final long serialVersionUID = 1L;

    private Long roleId;
    private Long powerId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
        ", roleId=" + roleId +
        ", powerId=" + powerId +
        "}";
    }
}
