package com.excel.demo.getExcel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wang.yangtx
 * @since 2019-05-14
 */
public class SysAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountId;

    private String userId;

    private String appId;

    private String accountName;

    private String loginPass;

    private String loginName;

    private String avatar;

    private String status;

    private String description;

    private String createdBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String customAccountId;

    private Integer loginFailTimes;

    private LocalDateTime lastLoginTime;

    private String initialPasswordFlag;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCustomAccountId() {
        return customAccountId;
    }

    public void setCustomAccountId(String customAccountId) {
        this.customAccountId = customAccountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getLoginFailTimes() {
        return loginFailTimes;
    }

    public void setLoginFailTimes(Integer loginFailTimes) {
        this.loginFailTimes = loginFailTimes;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getInitialPasswordFlag() {
        return initialPasswordFlag;
    }

    public void setInitialPasswordFlag(String initialPasswordFlag) {
        this.initialPasswordFlag = initialPasswordFlag;
    }

    @Override
    public String toString() {
        return "SysAccount{" +
                "accountId='" + accountId + '\'' +
                ", userId='" + userId + '\'' +
                ", appId='" + appId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                ", loginName='" + loginName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createTime=" + createTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", customAccountId='" + customAccountId + '\'' +
                ", loginFailTimes=" + loginFailTimes +
                ", lastLoginTime=" + lastLoginTime +
                ", initialPasswordFlag='" + initialPasswordFlag + '\'' +
                '}';
    }
}
