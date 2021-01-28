package com.excel.demo.getExcel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wang.yangtx
 * @since 2019-05-18
 */
public class SysOrg extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orgCode;

    private String displayName;

    /**
     * 可选值：
     * 1. 公司
     * 2. 部门
     * 3．外部组织
     */
    private String style;

    private String parentOrgCode;
    @TableField(exist = false)
    private Boolean hasChildren;

    /**
     * 定义组织的级别
     */
    private String orgLevel;

    private String functions;

    /**
     * 自定义属性，定义该组织的上级主管领导的UID 。
     * 例如：“zhangsan”
     */
    private String supervisor;

    private String orgManager;

    private String viceManager;

    /**
     * 同一个父组织下的组织的显示顺序。格式为数字
     */
    private String displayOrder;

    /**
     * 定义组织的状态，“0”表示正常状态，“1”表示锁定状态
     */
    private String status;

    private String companyId;

    private String telephoneNumber;

    private String facsimileTelephoneNumber;

    private String initials;

    private String description;

    private String leaf;

    private String createdBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private String appId;

    @TableField(exist = false)
    private String orgPath;

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getOrgManager() {
        return orgManager;
    }

    public void setOrgManager(String orgManager) {
        this.orgManager = orgManager;
    }

    public String getViceManager() {
        return viceManager;
    }

    public void setViceManager(String viceManager) {
        this.viceManager = viceManager;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFacsimileTelephoneNumber() {
        return facsimileTelephoneNumber;
    }

    public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
        this.facsimileTelephoneNumber = facsimileTelephoneNumber;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
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

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public String getIcon() {
        String icon = "";
        if (this.orgCode != null) {
            if (this.orgCode.equals("0")) {
                icon = "&#xe720;";
            } else {
                if (this.style.equals("1")) {
                    icon = "&#xe66e;";
                } else if (this.style.equals("2")) {
                    icon = "&#xe6e6;";
                } else {
                    icon = "&#xe61c;";
                }
            }
        }
        return icon;
    }

    @Override
    public String getParentId() {
        return this.parentOrgCode;
    }

    @Override
    public String getPKAttrName() {
        return "orgCode";
    }


    @Override
    public String toString() {
        return "SysOrg{" +
                "orgCode='" + orgCode + '\'' +
                ", displayName='" + displayName + '\'' +
                ", style='" + style + '\'' +
                ", parentOrgCode='" + parentOrgCode + '\'' +
                ", orgLevel='" + orgLevel + '\'' +
                ", functions='" + functions + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", orgManager='" + orgManager + '\'' +
                ", viceManager='" + viceManager + '\'' +
                ", displayOrder='" + displayOrder + '\'' +
                ", status='" + status + '\'' +
                ", companyId='" + companyId + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", facsimileTelephoneNumber='" + facsimileTelephoneNumber + '\'' +
                ", initials='" + initials + '\'' +
                ", description='" + description + '\'' +
                ", leaf='" + leaf + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createTime=" + createTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", appId='" + appId + '\'' +
                ", hasChildren='" + hasChildren + '\'' +
                ", orgPath='" + orgPath + '\'' +
                '}';
    }
}
