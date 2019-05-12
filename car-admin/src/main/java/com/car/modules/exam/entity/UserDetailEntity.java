package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:26
 */
@TableName("user_detail")
public class UserDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户选项id
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 学号
	 */
	private String userCode;
	/**
	 * 所在城市id
	 */
	private Long cityId;
	/**
	 * 城市名称
	 */
	private String cityName;
	/**
	 * 所属项目ID
	 */
	private Long projectId;
	/**
	 * 所属项目名称
	 */
	private String projectName;
	/**
	 * 性别(1为男性，2为女性)
	 */
	private Integer sex;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 购买短信提醒否，0：未购买；1：已购买
	 */
	private Integer buySmsRemind;
	/**
	 * 开通短信提醒否，0：未开通；1：已开通
	 */
	private Integer openSmsRemind;
	/**
	 * 用户类型(0在校生/1毕业生)
	 */
	private Integer userType;
	/**
	 * 用户图片
	 */
	private String userPicture;
	/**
	 * 用户设备类别(0安卓/1苹果)
	 */
	private Integer equipmentType;
	/**
	 * 设备型号
	 */
	private String equipmentModel;
	/**
	 * 系统版本号
	 */
	private String systemVersion;
	/**
	 * 软件版本号
	 */
	private String softVersion;
	/**
	 * 微信code
	 */
	private String code;
	/**
	 * 微信accessToken
	 */
	private String accessToken;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 微信有效期
	 */
	private Long expiresIn;
	/**
	 * 面授机构ID
	 */
	private Long offlineOrganizationId;
	/**
	 * 面授机构码
	 */
	private String organCode;
	/**
	 * 面授机构图片
	 */
	private String organPicture;
	/**
	 * 面授机构名称
	 */
	private String organName;
	/**
	 * 合作伙伴二维码图片
	 */
	private String userCodePicture;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 设置：用户选项id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户选项id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：学号
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 获取：学号
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 设置：所在城市id
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：所在城市id
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
	 * 设置：所属项目ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：所属项目ID
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：所属项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：所属项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：性别(1为男性，2为女性)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(1为男性，2为女性)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：购买短信提醒否，0：未购买；1：已购买
	 */
	public void setBuySmsRemind(Integer buySmsRemind) {
		this.buySmsRemind = buySmsRemind;
	}
	/**
	 * 获取：购买短信提醒否，0：未购买；1：已购买
	 */
	public Integer getBuySmsRemind() {
		return buySmsRemind;
	}
	/**
	 * 设置：开通短信提醒否，0：未开通；1：已开通
	 */
	public void setOpenSmsRemind(Integer openSmsRemind) {
		this.openSmsRemind = openSmsRemind;
	}
	/**
	 * 获取：开通短信提醒否，0：未开通；1：已开通
	 */
	public Integer getOpenSmsRemind() {
		return openSmsRemind;
	}
	/**
	 * 设置：用户类型(0在校生/1毕业生)
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型(0在校生/1毕业生)
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 设置：用户图片
	 */
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	/**
	 * 获取：用户图片
	 */
	public String getUserPicture() {
		return userPicture;
	}
	/**
	 * 设置：用户设备类别(0安卓/1苹果)
	 */
	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}
	/**
	 * 获取：用户设备类别(0安卓/1苹果)
	 */
	public Integer getEquipmentType() {
		return equipmentType;
	}
	/**
	 * 设置：设备型号
	 */
	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	/**
	 * 获取：设备型号
	 */
	public String getEquipmentModel() {
		return equipmentModel;
	}
	/**
	 * 设置：系统版本号
	 */
	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}
	/**
	 * 获取：系统版本号
	 */
	public String getSystemVersion() {
		return systemVersion;
	}
	/**
	 * 设置：软件版本号
	 */
	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
	/**
	 * 获取：软件版本号
	 */
	public String getSoftVersion() {
		return softVersion;
	}
	/**
	 * 设置：微信code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：微信code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：微信accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * 获取：微信accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * 设置：微信openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：微信openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：微信有效期
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	/**
	 * 获取：微信有效期
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}
	/**
	 * 设置：面授机构ID
	 */
	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}
	/**
	 * 获取：面授机构ID
	 */
	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}
	/**
	 * 设置：面授机构码
	 */
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	/**
	 * 获取：面授机构码
	 */
	public String getOrganCode() {
		return organCode;
	}
	/**
	 * 设置：面授机构图片
	 */
	public void setOrganPicture(String organPicture) {
		this.organPicture = organPicture;
	}
	/**
	 * 获取：面授机构图片
	 */
	public String getOrganPicture() {
		return organPicture;
	}
	/**
	 * 设置：面授机构名称
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：面授机构名称
	 */
	public String getOrganName() {
		return organName;
	}
	/**
	 * 设置：合作伙伴二维码图片
	 */
	public void setUserCodePicture(String userCodePicture) {
		this.userCodePicture = userCodePicture;
	}
	/**
	 * 获取：合作伙伴二维码图片
	 */
	public String getUserCodePicture() {
		return userCodePicture;
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
}
