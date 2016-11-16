package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the wel_completion_data_tbl database table.
 * 
 */
@Entity
@Table(name="wel_completion_data_tbl")
@NamedQuery(name="WelCompletionDataTbl.findAll", query="SELECT w FROM WelCompletionDataTbl w")
public class WelCompletionDataTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="well_id")
	private Integer wellId;

	@Column(name="completion_type")
	private String completionType;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="latera_defth_ft")
	private BigDecimal lateraDefthFt;

	@Column(name="lateral_defth_ft")
	private BigDecimal lateralDefthFt;

	@Column(name="perf_dia_inch")
	private BigDecimal perfDiaInch;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="well_dia_inch")
	private BigDecimal wellDiaInch;

	@Column(name="well_md_ft")
	private BigDecimal wellMdFt;

	@Column(name="well_tvd_ft")
	private BigDecimal wellTvdFt;

	@Column(name="well_type")
	private String wellType;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public WelCompletionDataTbl() {
	}

	public Integer getWellId() {
		return this.wellId;
	}

	public void setWellId(Integer wellId) {
		this.wellId = wellId;
	}

	public String getCompletionType() {
		return this.completionType;
	}

	public void setCompletionType(String completionType) {
		this.completionType = completionType;
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

	public BigDecimal getLateraDefthFt() {
		return this.lateraDefthFt;
	}

	public void setLateraDefthFt(BigDecimal lateraDefthFt) {
		this.lateraDefthFt = lateraDefthFt;
	}

	public BigDecimal getLateralDefthFt() {
		return this.lateralDefthFt;
	}

	public void setLateralDefthFt(BigDecimal lateralDefthFt) {
		this.lateralDefthFt = lateralDefthFt;
	}

	public BigDecimal getPerfDiaInch() {
		return this.perfDiaInch;
	}

	public void setPerfDiaInch(BigDecimal perfDiaInch) {
		this.perfDiaInch = perfDiaInch;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getWellDiaInch() {
		return this.wellDiaInch;
	}

	public void setWellDiaInch(BigDecimal wellDiaInch) {
		this.wellDiaInch = wellDiaInch;
	}

	public BigDecimal getWellMdFt() {
		return this.wellMdFt;
	}

	public void setWellMdFt(BigDecimal wellMdFt) {
		this.wellMdFt = wellMdFt;
	}

	public BigDecimal getWellTvdFt() {
		return this.wellTvdFt;
	}

	public void setWellTvdFt(BigDecimal wellTvdFt) {
		this.wellTvdFt = wellTvdFt;
	}

	public String getWellType() {
		return this.wellType;
	}

	public void setWellType(String wellType) {
		this.wellType = wellType;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}