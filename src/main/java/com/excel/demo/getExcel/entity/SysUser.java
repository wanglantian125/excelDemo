package com.excel.demo.getExcel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wang.yangtx
 * @since 2019-05-14
 */
public class  SysUser extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String userNo;

    private String appId;

    private String orgCode;

    private String companyId;

    private String cn;

    private String sn;

    private String description;

    private String email;

    private String nation;

    private String gender;

    private LocalDateTime birthday;

    private String c;

    private String religion;

    private String telephoneNumber;

    private String mobile;

    private String facsimileTelephoneNumber;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;

    private LocalDateTime passwordModifiedDate;

    private String idCardNumber;

    private String employeeType;

    private String createdBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private String employeeNumber;

    /**
     * 填写为数字，要求准确。例如：“12”表示12级
     */
    private Integer userLevel;

    /**
     * 岗位名称。如：IT规划，系统管理员等
     */
    private String levelName;

    /**
     * 定义员工套入职级，员工竞聘的岗位职级和实际职级会存在不一致，例如新员工入职后竞聘的岗位为10级，但是新员工实际职级可能只有7级，则7级为其套入职级。
     */
    private Integer category;

    /**
     * 定义用户的业务职责编码，可为多值。
     * 例如：“财务”
     */
    private String functions;

    private String displayOrder;

    private String duty;

    private Integer positionLevel;

    private String supporterCorpName;

    private String supporterDept;

    private String supporterCorpContact;

    private String supervisor;

    private String post;

    private String provinceId;
    @TableField(exist = false)
    private String provinceName;
    private String cityId;
    @TableField(exist = false)
    private String cityName;
    private String countyId;
    @TableField(exist = false)
    private String countyName;
    @TableField(exist = false)
    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFacsimileTelephoneNumber() {
        return facsimileTelephoneNumber;
    }

    public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
        this.facsimileTelephoneNumber = facsimileTelephoneNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPasswordModifiedDate() {
        return passwordModifiedDate;
    }

    public void setPasswordModifiedDate(LocalDateTime passwordModifiedDate) {
        this.passwordModifiedDate = passwordModifiedDate;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
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

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Integer getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(Integer positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getSupporterCorpName() {
        return supporterCorpName;
    }

    public void setSupporterCorpName(String supporterCorpName) {
        this.supporterCorpName = supporterCorpName;
    }

    public String getSupporterDept() {
        return supporterDept;
    }

    public void setSupporterDept(String supporterDept) {
        this.supporterDept = supporterDept;
    }

    public String getSupporterCorpContact() {
        return supporterCorpContact;
    }

    public void setSupporterCorpContact(String supporterCorpContact) {
        this.supporterCorpContact = supporterCorpContact;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getLeaf() {
        return "";
    }

    @Override
    public String getIcon() {
        String icon = "&#xe61c";
        return icon;
    }

    @Override
    public String getParentId() {
        return this.companyId;
    }

    @Override
    public String getPKAttrName() {
        return "orgCode";
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }
    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", userNo='" + userNo + '\'' +
                ", appId='" + appId + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", companyId='" + companyId + '\'' +
                ", cn='" + cn + '\'' +
                ", sn='" + sn + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", nation='" + nation + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", c='" + c + '\'' +
                ", religion='" + religion + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", facsimileTelephoneNumber='" + facsimileTelephoneNumber + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", passwordModifiedDate=" + passwordModifiedDate +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createTime=" + createTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", userLevel=" + userLevel +
                ", levelName='" + levelName + '\'' +
                ", category=" + category +
                ", functions='" + functions + '\'' +
                ", displayOrder='" + displayOrder + '\'' +
                ", duty='" + duty + '\'' +
                ", positionLevel=" + positionLevel +
                ", supporterCorpName='" + supporterCorpName + '\'' +
                ", supporterDept='" + supporterDept + '\'' +
                ", supporterCorpContact='" + supporterCorpContact + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", post='" + post + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", countyId='" + countyId + '\'' +
                '}';
    }
}
