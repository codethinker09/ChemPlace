package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the calibration_tbl database table.
 * 
 */
@Entity
@Table(name="calibration_tbl")
@NamedQuery(name="CalibrationTbl.findAll", query="SELECT c FROM CalibrationTbl c")
public class CalibrationTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="calibration_id")
	private Integer calibrationId;

	@Column(name="calibration_interstial")
	private BigDecimal calibrationInterstial;

	@Column(name="calibration_pvto_breakthrough")
	private BigDecimal calibrationPvtoBreakthrough;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public CalibrationTbl() {
	}

	public Integer getCalibrationId() {
		return this.calibrationId;
	}

	public void setCalibrationId(Integer calibrationId) {
		this.calibrationId = calibrationId;
	}

	public BigDecimal getCalibrationInterstial() {
		return this.calibrationInterstial;
	}

	public void setCalibrationInterstial(BigDecimal calibrationInterstial) {
		this.calibrationInterstial = calibrationInterstial;
	}

	public BigDecimal getCalibrationPvtoBreakthrough() {
		return this.calibrationPvtoBreakthrough;
	}

	public void setCalibrationPvtoBreakthrough(BigDecimal calibrationPvtoBreakthrough) {
		this.calibrationPvtoBreakthrough = calibrationPvtoBreakthrough;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}