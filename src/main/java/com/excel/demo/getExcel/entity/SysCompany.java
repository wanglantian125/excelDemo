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
 * @since 2019-11-20
 */
public class SysCompany extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String companyId;

    private String address;

    private String companyName;

    private String abbre;

    private String description;

    private String createdBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    /**
     * 0-正常
     * 1-删除
     */
    private String status;

//    @TableField("postalCode")
    private String postalCode;

    private String appId;


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbbre() {
        return abbre;
    }

    public void setAbbre(String abbre) {
        this.abbre = abbre;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getIcon() {
        String icon = "";
        if (this.getCompanyId() != null) {
            if (this.getCompanyId().equals("0")) {
                icon = "&#xe720;";
            } else {
                icon = "&#xe66e;";
            }
        }
        return icon;
    }

    @Override
    public String getParentId() {
        return "0";
    }

    @Override
    public String getPKAttrName() {
        return "companyId";
    }

    @Override
    public String getLeaf() {
        return "1";
    }

    @Override
    public String toString() {
        return "SysCompany{" +
                "companyId='" + companyId + '\'' +
                ", address='" + address + '\'' +
                ", companyName='" + companyName + '\'' +
                ", abbre='" + abbre + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createTime=" + createTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", status='" + status + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
