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
 * @since 2019-05-17
 */
public class SysAccountRoleRela implements Serializable {

private static final long serialVersionUID=1L;

    private String id;

    private String accountId;

    private String roleId;

    private String createdBy;

    private LocalDateTime createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "SysAccountRoleRela{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
