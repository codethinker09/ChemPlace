package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the reservoirlethology_tbl database table.
 * 
 */
@Entity
@Table(name="reservoirlethology_tbl")
@NamedQuery(name="ReservoirlethologyTbl.findAll", query="SELECT r FROM ReservoirlethologyTbl r")
public class ReservoirlethologyTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reservoirlethology_id")
	private Integer reservoirlethologyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="fluid_in_place")
	private String fluidInPlace;

	@Column(name="form_defth_ft")
	private BigDecimal formDefthFt;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="perm_md")
	private BigDecimal permMd;

	private BigDecimal poro;

	@Column(name="pre_stim_skin")
	private BigDecimal preStimSkin;

	@Column(name="to_defth_ft")
	private BigDecimal toDefthFt;

	@Column(name="tvd_ft")
	private BigDecimal tvdFt;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="zone_press_psi")
	private BigDecimal zonePressPsi;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public ReservoirlethologyTbl() {
	}

	public Integer getReservoirlethologyId() {
		return this.reservoirlethologyId;
	}

	public void setReservoirlethologyId(Integer reservoirlethologyId) {
		this.reservoirlethologyId = reservoirlethologyId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getFluidInPlace() {
		return this.fluidInPlace;
	}

	public void setFluidInPlace(String fluidInPlace) {
		this.fluidInPlace = fluidInPlace;
	}

	public BigDecimal getFormDefthFt() {
		return this.formDefthFt;
	}

	public void setFormDefthFt(BigDecimal formDefthFt) {
		this.formDefthFt = formDefthFt;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public BigDecimal getPermMd() {
		return this.permMd;
	}

	public void setPermMd(BigDecimal permMd) {
		this.permMd = permMd;
	}

	public BigDecimal getPoro() {
		return this.poro;
	}

	public void setPoro(BigDecimal poro) {
		this.poro = poro;
	}

	public BigDecimal getPreStimSkin() {
		return this.preStimSkin;
	}

	public void setPreStimSkin(BigDecimal preStimSkin) {
		this.preStimSkin = preStimSkin;
	}

	public BigDecimal getToDefthFt() {
		return this.toDefthFt;
	}

	public void setToDefthFt(BigDecimal toDefthFt) {
		this.toDefthFt = toDefthFt;
	}

	public BigDecimal getTvdFt() {
		return this.tvdFt;
	}

	public void setTvdFt(BigDecimal tvdFt) {
		this.tvdFt = tvdFt;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getZonePressPsi() {
		return this.zonePressPsi;
	}

	public void setZonePressPsi(BigDecimal zonePressPsi) {
		this.zonePressPsi = zonePressPsi;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}