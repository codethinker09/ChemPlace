package com.chemplace.view.model.beans;

import java.io.Serializable;

import javax.persistence.*;

import com.chemplace.view.model.beans.ProjectTbl;

import java.sql.Timestamp;
 


/**
 * The persistent class for the output_acid_penetration_tbl database table.
 * 
 */
@Entity
@Table(name="output_acid_penetration_tbl")
@NamedQuery(name="OutputAcidPenetrationTbl.findAll", query="SELECT o FROM OutputAcidPenetrationTbl o")
public class OutputAcidPenetrationTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="acid_penetration_id")
	private Integer acidPenetrationId;

	@Column(name="\"Acid_penetration_data_no\"")
	private Integer acid_penetration_data_no;

	@Column(name="create_date")
	private Timestamp createDate;

	public Float getDefthFtstart() {
		return defthFtstart;
	}

	public void setDefthFtstart(Float defthFtstart) {
		this.defthFtstart = defthFtstart;
	}

	public Float getDefthFtend() {
		return defthFtend;
	}

	public void setDefthFtend(Float defthFtend) {
		this.defthFtend = defthFtend;
	}

	@Column(name="defth_ft_start")
	private Float defthFtstart;
	
	@Column(name="defth_ft_end")
	private Float defthFtend;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="penetration_length_ft")
	private Float penetrationLengthFt;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public OutputAcidPenetrationTbl() {
	}

	public Integer getAcidPenetrationId() {
		return this.acidPenetrationId;
	}

	public void setAcidPenetrationId(Integer acidPenetrationId) {
		this.acidPenetrationId = acidPenetrationId;
	}

	public Integer getAcid_penetration_data_no() {
		return this.acid_penetration_data_no;
	}

	public void setAcid_penetration_data_no(Integer acid_penetration_data_no) {
		this.acid_penetration_data_no = acid_penetration_data_no;
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

	public Float getPenetrationLengthFt() {
		return this.penetrationLengthFt;
	}

	public void setPenetrationLengthFt(Float penetrationLengthFt) {
		this.penetrationLengthFt = penetrationLengthFt;
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