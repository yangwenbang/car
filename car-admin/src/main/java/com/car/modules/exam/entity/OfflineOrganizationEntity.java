package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.car.common.utils.json.MyDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
@TableName("offline_organization")
public class OfflineOrganizationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 机构名称
     */
    @NotBlank(message="请输入机构名称")
    private String organizationName;
    /**
     * 机构描述
     */
    private String organizationDesc;
    /**
     * 项目ID
     */
    @NotNull(message="请选择项目")
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 机构地址
     */
    private String organizationAddress;
    /**
     * 联系人名称
     */
    private String contact;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 省份ID
     */
    private Long provinceId;
    /**
     * 省份名称
     */
    private String provinceName;
    /**
     * 城市ID
     */
    @NotNull(message="请选择城市")
    private Long cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 状态(0启用/1禁用)
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 创建时间
     */
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date updateTime;

    private String organizationPicture;

    private String organizationCode;

    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：机构名称
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * 获取：机构名称
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置：机构描述
     */
    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    /**
     * 获取：机构描述
     */
    public String getOrganizationDesc() {
        return organizationDesc;
    }

    /**
     * 设置：项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取：项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置：项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取：项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置：机构地址
     */
    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    /**
     * 获取：机构地址
     */
    public String getOrganizationAddress() {
        return organizationAddress;
    }

    /**
     * 设置：联系人名称
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取：联系人名称
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置：联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：省份ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取：省份ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置：省份名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取：省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置：城市ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取：城市ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置：城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取：城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置：状态(0启用/1禁用)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态(0启用/1禁用)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getOrganizationPicture() {
        return organizationPicture;
    }

    public void setOrganizationPicture(String organizationPicture) {
        this.organizationPicture = organizationPicture;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
}
