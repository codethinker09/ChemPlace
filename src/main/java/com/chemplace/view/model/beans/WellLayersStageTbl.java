package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the well_layers_stage_tbl database table.
 * 
 */
@Entity
@Table(name="well_layers_stage_tbl")
@NamedQuery(name="WellLayersStageTbl.findAll", query="SELECT w FROM WellLayersStageTbl w")
public class WellLayersStageTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="locseq_id")
	private Integer locseqId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="no_of_layers")
	private Integer noOfLayers;

	@Column(name="no_of_stages")
	private Integer noOfStages;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="well_name")
	private String wellName;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public WellLayersStageTbl() {
	}

	public Integer getLocseqId() {
		return this.locseqId;
	}

	public void setLocseqId(Integer locseqId) {
		this.locseqId = locseqId;
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

	public Integer getNoOfLayers() {
		return this.noOfLayers;
	}

	public void setNoOfLayers(Integer noOfLayers) {
		this.noOfLayers = noOfLayers;
	}

	public Integer getNoOfStages() {
		return this.noOfStages;
	}

	public void setNoOfStages(Integer noOfStages) {
		this.noOfStages = noOfStages;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWellName() {
		return this.wellName;
	}

	public void setWellName(String wellName) {
		this.wellName = wellName;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

	@Override
	public String toString() {
		return "WellLayersStageTbl [locseqId=" + locseqId + ", createDate="
				+ createDate + ", lastUpdate=" + lastUpdate + ", noOfLayers="
				+ noOfLayers + ", noOfStages=" + noOfStages + ", userId="
				+ userId + ", wellName=" + wellName + ", projectTbl="
				+ projectTbl + "]";
	}
	
	

}