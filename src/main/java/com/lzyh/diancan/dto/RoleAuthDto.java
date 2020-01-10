package com.lzyh.diancan.dto;


import java.io.Serializable;

/**
 * @author huangrui
 */
public class RoleAuthDto implements Serializable {
    /**
     * 权限ID
     */
    private Long authId;
    /**
     * 权限代码
     */
    private String authCode;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    public RoleAuthDto(Long authId, String authCode, Long roleId, String roleName) {
        this.authId = authId;
        this.authCode = authCode;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleAuthDto() {
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "roleAuthDto{" +
                "authId=" + authId +
                ", authCode='" + authCode + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
