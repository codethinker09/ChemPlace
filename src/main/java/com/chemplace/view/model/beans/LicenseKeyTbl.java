package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the license_key_tbl database table.
 * 
 */
@Entity
@Table(name="license_key_tbl")
@NamedQuery(name="LicenseKeyTbl.findAll", query="SELECT l FROM LicenseKeyTbl l")
public class LicenseKeyTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="license_id")
	private Integer licenseId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="end_lic_date")
	private Timestamp endLicDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="license_key")
	private String licenseKey;

	@Column(name="mac_address")
	private String macAddress;

	@Column(name="project_id")
	private Integer projectId;

	@Column(name="start_lic_date")
	private Timestamp startLicDate;

	@Column(name="status_lic")
	private String statusLic;

	@Column(name="user_id")
	private Integer userId;

	public LicenseKeyTbl() {
	}

	public Integer getLicenseId() {
		return this.licenseId;
	}

	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getEndLicDate() {
		return this.endLicDate;
	}

	public void setEndLicDate(Timestamp endLicDate) {
		this.endLicDate = endLicDate;
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

	public String getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Timestamp getStartLicDate() {
		return this.startLicDate;
	}

	public void setStartLicDate(Timestamp startLicDate) {
		this.startLicDate = startLicDate;
	}

	public String getStatusLic() {
		return this.statusLic;
	}

	public void setStatusLic(String statusLic) {
		this.statusLic = statusLic;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}