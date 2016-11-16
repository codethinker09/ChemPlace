package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the sensitivity_analysis_tbl database table.
 * 
 */
@Entity
@Table(name="sensitivity_analysis_tbl")
@NamedQuery(name="SensitivityAnalysisTbl.findAll", query="SELECT s FROM SensitivityAnalysisTbl s")
public class SensitivityAnalysisTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sensitivity_analysis_id")
	private Integer sensitivityAnalysisId;

	private BigDecimal case1;

	private BigDecimal case2;

	private BigDecimal case3;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="sensitivity_analysis_name")
	private String sensitivityAnalysisName;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public SensitivityAnalysisTbl() {
	}

	public Integer getSensitivityAnalysisId() {
		return this.sensitivityAnalysisId;
	}

	public void setSensitivityAnalysisId(Integer sensitivityAnalysisId) {
		this.sensitivityAnalysisId = sensitivityAnalysisId;
	}

	public BigDecimal getCase1() {
		return this.case1;
	}

	public void setCase1(BigDecimal case1) {
		this.case1 = case1;
	}

	public BigDecimal getCase2() {
		return this.case2;
	}

	public void setCase2(BigDecimal case2) {
		this.case2 = case2;
	}

	public BigDecimal getCase3() {
		return this.case3;
	}

	public void setCase3(BigDecimal case3) {
		this.case3 = case3;
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

	public String getSensitivityAnalysisName() {
		return this.sensitivityAnalysisName;
	}

	public void setSensitivityAnalysisName(String sensitivityAnalysisName) {
		this.sensitivityAnalysisName = sensitivityAnalysisName;
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