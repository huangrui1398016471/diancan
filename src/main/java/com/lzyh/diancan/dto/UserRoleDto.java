package com.lzyh.diancan.dto;

import java.io.Serializable;

/**
 * @author huangrui
 * 用户角色传输对象
 */
public class UserRoleDto implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 手机号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 头像URL
     */
    private String headImg;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    public UserRoleDto(Long userId, String account, String password, String userName, String headImg, Long roleId, String roleName) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.headImg = headImg;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public UserRoleDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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
        return "userRoleDto{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}
