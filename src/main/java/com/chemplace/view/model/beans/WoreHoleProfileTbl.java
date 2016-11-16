package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the wore_hole_profile_tbl database table.
 * 
 */
@Entity
@Table(name="wore_hole_profile_tbl")
@NamedQuery(name="WoreHoleProfileTbl.findAll", query="SELECT w FROM WoreHoleProfileTbl w")
public class WoreHoleProfileTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wore_hole_profile_id")
	private Integer woreHoleProfileId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="wore_hole_bm")
	private BigDecimal woreHoleBm;

	@Column(name="wore_hole_weff")
	private BigDecimal woreHoleWeff;

	@Column(name="worm_hole_cor_constrant")
	private BigDecimal wormHoleCorConstrant;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public WoreHoleProfileTbl() {
	}

	public Integer getWoreHoleProfileId() {
		return this.woreHoleProfileId;
	}

	public void setWoreHoleProfileId(Integer woreHoleProfileId) {
		this.woreHoleProfileId = woreHoleProfileId;
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

	public BigDecimal getWoreHoleBm() {
		return this.woreHoleBm;
	}

	public void setWoreHoleBm(BigDecimal woreHoleBm) {
		this.woreHoleBm = woreHoleBm;
	}

	public BigDecimal getWoreHoleWeff() {
		return this.woreHoleWeff;
	}

	public void setWoreHoleWeff(BigDecimal woreHoleWeff) {
		this.woreHoleWeff = woreHoleWeff;
	}

	public BigDecimal getWormHoleCorConstrant() {
		return this.wormHoleCorConstrant;
	}

	public void setWormHoleCorConstrant(BigDecimal wormHoleCorConstrant) {
		this.wormHoleCorConstrant = wormHoleCorConstrant;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}