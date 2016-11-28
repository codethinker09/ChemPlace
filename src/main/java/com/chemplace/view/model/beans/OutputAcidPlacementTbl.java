package com.chemplace.view.model.beans;

import java.io.Serializable;

import javax.persistence.*;

import com.chemplace.view.model.beans.ProjectTbl;

import java.sql.Timestamp;
 


/**
 * The persistent class for the output_acid_placement_tbl database table.
 * 
 */
@Entity
@Table(name="output_acid_placement_tbl")
@NamedQuery(name="OutputAcidPlacementTbl.findAll", query="SELECT o FROM OutputAcidPlacementTbl o")
public class OutputAcidPlacementTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="acid_placement_id")
	private Integer acidPlacementId;

	@Column(name="acid_plcment_data_no")
	private Integer acidPlcmentDataNo;

	@Column(name="create_date")
	private Timestamp createDate;

	public float getDefthFtstart() {
		return defthFtstart;
	}

	public void setDefthFtstart(float defthFtstart) {
		this.defthFtstart = defthFtstart;
	}

	public float getDefthFtend() {
		return defthFtend;
	}

	public void setDefthFtend(float defthFtend) {
		this.defthFtend = defthFtend;
	}

	@Column(name="defth_ft_start")
	private float defthFtstart;
	
	
	@Column(name="defth_ft_end")
	private float defthFtend;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="volume_data_percent")
	private float volumeDataPercent;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public OutputAcidPlacementTbl() {
	}

	public Integer getAcidPlacementId() 
	{
		return this.acidPlacementId;
	}

	public void setAcidPlacementId(Integer acidPlacementId) {
		this.acidPlacementId = acidPlacementId;
	}

	public Integer getAcidPlcmentDataNo() {
		return this.acidPlcmentDataNo;
	}

	public void setAcidPlcmentDataNo(Integer acidPlcmentDataNo) {
		this.acidPlcmentDataNo = acidPlcmentDataNo;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/*public float getDefthFt() {
		return this.defthFt;
	}

	public void setDefthFt(float defthFt) {
		this.defthFt = defthFt;
	}*/

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

	public float getVolumeDataPercent() {
		return this.volumeDataPercent;
	}

	public void setVolumeDataPercent(float volumeDataPercent) {
		this.volumeDataPercent = volumeDataPercent;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}