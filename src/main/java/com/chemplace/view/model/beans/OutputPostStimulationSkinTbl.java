package com.chemplace.view.model.beans;

import java.io.Serializable;

import javax.persistence.*;

import com.chemplace.view.model.beans.ProjectTbl;

import java.sql.Timestamp;
 

/**
 * The persistent class for the output_post_stimulation_skin_tbl database table.
 * 
 */
@Entity
@Table(name="output_post_stimulation_skin_tbl")
@NamedQuery(name="OutputPostStimulationSkinTbl.findAll", query="SELECT o FROM OutputPostStimulationSkinTbl o")
public class OutputPostStimulationSkinTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_stimulation_skin_id")
	private Integer postStimulationSkinId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="defth_ft_start")
	private Float defthFtStart;
	
	@Column(name="defth_ft_end")
	private Float defthFtEnd;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="post_sti_skin_data_no")
	private Integer postStiSkinDataNo;

	@Column(name="skin_value")
	private Float skinValue;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public OutputPostStimulationSkinTbl() {
	}

	public Integer getPostStimulationSkinId() {
		return this.postStimulationSkinId;
	}

	public void setPostStimulationSkinId(Integer postStimulationSkinId) {
		this.postStimulationSkinId = postStimulationSkinId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	 
	public Float getDefthFtStart() {
		return defthFtStart;
	}

	public void setDefthFtStart(Float defthFtStart) {
		this.defthFtStart = defthFtStart;
	}

	public Float getDefthFtEnd() {
		return defthFtEnd;
	}

	public void setDefthFtEnd(Float defthFtEnd) {
		this.defthFtEnd = defthFtEnd;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getPostStiSkinDataNo() {
		return this.postStiSkinDataNo;
	}

	public void setPostStiSkinDataNo(Integer postStiSkinDataNo) {
		this.postStiSkinDataNo = postStiSkinDataNo;
	}

	public Float getSkinValue() {
		return this.skinValue;
	}

	public void setSkinValue(Float skinValue) {
		this.skinValue = skinValue;
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