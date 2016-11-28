package com.chemplace.view.model.beans;

import java.io.Serializable;

import javax.persistence.*;

import com.chemplace.view.model.beans.ProjectTbl;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the output_proposed_stimulation_design_tbl database table.
 * 
 */
@Entity
@Table(name="output_proposed_stimulation_design_tbl")
@NamedQuery(name="OutputProposedStimulationDesignTbl.findAll", query="SELECT o FROM OutputProposedStimulationDesignTbl o")
public class OutputProposedStimulationDesignTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="proposed_stimulation_design_id")
	private Integer proposedStimulationDesignId;

	@Column(name="conc_per")
	private BigDecimal concPer;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="no_id")
	private Integer noId;

	@Column(name="pro_sti_design_data_no")
	private Integer proStiDesignDataNo;

	@Column(name="pump_rate_bpm")
	private BigDecimal pumpRateBpm;

	@Column(name="pumping_pressure_psi")
	private BigDecimal pumpingPressurePsi;

	@Column(name="stage_name")
	private String stageName;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="vis_cp")
	private BigDecimal visCp;

	@Column(name="volumn_bbls")
	private BigDecimal volumnBbls;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public OutputProposedStimulationDesignTbl() {
	}

	public Integer getProposedStimulationDesignId() {
		return this.proposedStimulationDesignId;
	}

	public void setProposedStimulationDesignId(Integer proposedStimulationDesignId) {
		this.proposedStimulationDesignId = proposedStimulationDesignId;
	}

	public BigDecimal getConcPer() {
		return this.concPer;
	}

	public void setConcPer(BigDecimal concPer) {
		this.concPer = concPer;
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

	public Integer getNoId() {
		return this.noId;
	}

	public void setNoId(Integer noId) {
		this.noId = noId;
	}

	public Integer getProStiDesignDataNo() {
		return this.proStiDesignDataNo;
	}

	public void setProStiDesignDataNo(Integer proStiDesignDataNo) {
		this.proStiDesignDataNo = proStiDesignDataNo;
	}

	public BigDecimal getPumpRateBpm() {
		return this.pumpRateBpm;
	}

	public void setPumpRateBpm(BigDecimal pumpRateBpm) {
		this.pumpRateBpm = pumpRateBpm;
	}

	public BigDecimal getPumpingPressurePsi() {
		return this.pumpingPressurePsi;
	}

	public void setPumpingPressurePsi(BigDecimal pumpingPressurePsi) {
		this.pumpingPressurePsi = pumpingPressurePsi;
	}

	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getVisCp() {
		return this.visCp;
	}

	public void setVisCp(BigDecimal visCp) {
		this.visCp = visCp;
	}

	public BigDecimal getVolumnBbls() {
		return this.volumnBbls;
	}

	public void setVolumnBbls(BigDecimal volumnBbls) {
		this.volumnBbls = volumnBbls;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}