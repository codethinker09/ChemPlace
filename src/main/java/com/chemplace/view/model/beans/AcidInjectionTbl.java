package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the acid_injection_tbl database table.
 * 
 */
@Entity
@Table(name="acid_injection_tbl")
@NamedQuery(name="AcidInjectionTbl.findAll", query="SELECT a FROM AcidInjectionTbl a")
public class AcidInjectionTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="acid_inj_id")
	private Integer acidInjId;

	private BigDecimal conc;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="entity_fric_loss")
	private BigDecimal entityFricLoss;

	@Column(name="inj_defth_ft")
	private BigDecimal injDefthFt;

	@Column(name="inj_press_psi")
	private BigDecimal injPressPsi;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="pump_rate_bmp")
	private BigDecimal pumpRateBmp;

	private String stage;

	@Column(name="stavage_vol_bbls")
	private BigDecimal stavageVolBbls;

	@Column(name="user_id")
	private Integer userId;

	private BigDecimal vise;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public AcidInjectionTbl() {
	}

	public Integer getAcidInjId() {
		return this.acidInjId;
	}

	public void setAcidInjId(Integer acidInjId) {
		this.acidInjId = acidInjId;
	}

	public BigDecimal getConc() {
		return this.conc;
	}

	public void setConc(BigDecimal conc) {
		this.conc = conc;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getEntityFricLoss() {
		return this.entityFricLoss;
	}

	public void setEntityFricLoss(BigDecimal entityFricLoss) {
		this.entityFricLoss = entityFricLoss;
	}

	public BigDecimal getInjDefthFt() {
		return this.injDefthFt;
	}

	public void setInjDefthFt(BigDecimal injDefthFt) {
		this.injDefthFt = injDefthFt;
	}

	public BigDecimal getInjPressPsi() {
		return this.injPressPsi;
	}

	public void setInjPressPsi(BigDecimal injPressPsi) {
		this.injPressPsi = injPressPsi;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public BigDecimal getPumpRateBmp() {
		return this.pumpRateBmp;
	}

	public void setPumpRateBmp(BigDecimal pumpRateBmp) {
		this.pumpRateBmp = pumpRateBmp;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public BigDecimal getStavageVolBbls() {
		return this.stavageVolBbls;
	}

	public void setStavageVolBbls(BigDecimal stavageVolBbls) {
		this.stavageVolBbls = stavageVolBbls;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getVise() {
		return this.vise;
	}

	public void setVise(BigDecimal vise) {
		this.vise = vise;
	}

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}