package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_tbl database table.
 * 
 */
@Entity
@Table(name="user_tbl")
@NamedQuery(name="UserTbl.findAll", query="SELECT u FROM UserTbl u")
public class UserTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="license_key")
	private String licenseKey;

	@Column(name="user_address")
	private String userAddress;

	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_loginid")
	private String userLoginid;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_phone")
	private String userPhone;

	@Column(name="user_status")
	private String userStatus;

	//bi-directional many-to-one association to ProjectTbl
	@OneToMany(mappedBy="userTbl")
	private List<ProjectTbl> projectTbls;

	public UserTbl() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLicenseKey() {
		return this.licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLoginid() {
		return this.userLoginid;
	}

	public void setUserLoginid(String userLoginid) {
		this.userLoginid = userLoginid;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<ProjectTbl> getProjectTbls() {
		return this.projectTbls;
	}

	public void setProjectTbls(List<ProjectTbl> projectTbls) {
		this.projectTbls = projectTbls;
	}

	public ProjectTbl addProjectTbl(ProjectTbl projectTbl) {
		getProjectTbls().add(projectTbl);
		projectTbl.setUserTbl(this);

		return projectTbl;
	}

	public ProjectTbl removeProjectTbl(ProjectTbl projectTbl) {
		getProjectTbls().remove(projectTbl);
		projectTbl.setUserTbl(null);

		return projectTbl;
	}

}