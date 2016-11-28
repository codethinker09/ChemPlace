package com.chemplace.view.model.beans;

import java.io.Serializable;

import javax.persistence.*;

import com.chemplace.view.model.beans.ProjectTbl;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the output_post_stimulation_production_tbl database table.
 * 
 */
@Entity
@Table(name="output_post_stimulation_production_tbl")
@NamedQuery(name="OutputPostStimulationProductionTbl.findAll", query="SELECT o FROM OutputPostStimulationProductionTbl o")
public class OutputPostStimulationProductionTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_stimulation_production_id")
	private Integer postStimulationProductionId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="date_production")
	private Timestamp dateProduction;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="post_sti_production_data_no")
	private Integer postStiProductionDataNo;

	@Column(name="production_bbls_d")
	private BigDecimal productionBblsD;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public OutputPostStimulationProductionTbl() {
	}

	public Integer getPostStimulationProductionId() {
		return this.postStimulationProductionId;
	}

	public void setPostStimulationProductionId(Integer postStimulationProductionId) {
		this.postStimulationProductionId = postStimulationProductionId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDateProduction() {
		return this.dateProduction;
	}

	public void setDateProduction(Timestamp dateProduction) {
		this.dateProduction = dateProduction;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getPostStiProductionDataNo() {
		return this.postStiProductionDataNo;
	}

	public void setPostStiProductionDataNo(Integer postStiProductionDataNo) {
		this.postStiProductionDataNo = postStiProductionDataNo;
	}

	public BigDecimal getProductionBblsD() {
		return this.productionBblsD;
	}

	public void setProductionBblsD(BigDecimal productionBblsD) {
		this.productionBblsD = productionBblsD;
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