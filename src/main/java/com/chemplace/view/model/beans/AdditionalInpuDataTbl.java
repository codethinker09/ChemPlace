package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the additional_inpu_data_tbl database table.
 * 
 */
@Entity
@Table(name="additional_inpu_data_tbl")
@NamedQuery(name="AdditionalInpuDataTbl.findAll", query="SELECT a FROM AdditionalInpuDataTbl a")
public class AdditionalInpuDataTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="additional_inpu_data_id")
	private Integer additionalInpuDataId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="diverter_cosnt_n")
	private BigDecimal diverterCosntN;

	@Column(name="driverter_const_k")
	private BigDecimal driverterConstK;

	@Column(name="frac_apperture_ft")
	private BigDecimal fracAppertureFt;
	
	@Column(name="form_vol_factor")
	private BigDecimal formVolumeFactor;

	public BigDecimal getFormVolumeFactor() {
		return formVolumeFactor;
	}

	public void setFormVolumeFactor(BigDecimal formVolumeFactor) {
		this.formVolumeFactor = formVolumeFactor;
	}

	@Column(name="frac_length_ft")
	private BigDecimal fracLengthFt;

	@Column(name="frac_lenth_inch")
	private BigDecimal fracLenthInch;

	@Column(name="frac_press_psi")
	private BigDecimal fracPressPsi;

	@Column(name="jet_dia_inch")
	private BigDecimal jetDiaInch;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="max_press_psi")
	private BigDecimal maxPressPsi;

	@Column(name="no_of_grids")
	private BigDecimal noOfGrids;

	@Column(name="no_of_timepsteps")
	private BigDecimal noOfTimepsteps;

	@Column(name="post_prod_at_press_psi")
	private BigDecimal postProdAtPressPsi;

	@Column(name="post_prod_bbls")
	private BigDecimal postProdBbls;

	@Column(name="rock_density_kg")
	private BigDecimal rockDensityKg;

	@Column(name="stimulation_type")
	private String stimulationType;

	@Column(name="tub_friction_coff")
	private BigDecimal tubFrictionCoff;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public AdditionalInpuDataTbl() {
	}

	public Integer getAdditionalInpuDataId() {
		return this.additionalInpuDataId;
	}

	public void setAdditionalInpuDataId(Integer additionalInpuDataId) {
		this.additionalInpuDataId = additionalInpuDataId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getDiverterCosntN() {
		return this.diverterCosntN;
	}

	public void setDiverterCosntN(BigDecimal diverterCosntN) {
		this.diverterCosntN = diverterCosntN;
	}

	public BigDecimal getDriverterConstK() {
		return this.driverterConstK;
	}

	public void setDriverterConstK(BigDecimal driverterConstK) {
		this.driverterConstK = driverterConstK;
	}

	public BigDecimal getFracAppertureFt() {
		return this.fracAppertureFt;
	}

	public void setFracAppertureFt(BigDecimal fracAppertureFt) {
		this.fracAppertureFt = fracAppertureFt;
	}

	public BigDecimal getFracLengthFt() {
		return this.fracLengthFt;
	}

	public void setFracLengthFt(BigDecimal fracLengthFt) {
		this.fracLengthFt = fracLengthFt;
	}

	public BigDecimal getFracLenthInch() {
		return this.fracLenthInch;
	}

	public void setFracLenthInch(BigDecimal fracLenthInch) {
		this.fracLenthInch = fracLenthInch;
	}

	public BigDecimal getFracPressPsi() {
		return this.fracPressPsi;
	}

	public void setFracPressPsi(BigDecimal fracPressPsi) {
		this.fracPressPsi = fracPressPsi;
	}

	public BigDecimal getJetDiaInch() {
		return this.jetDiaInch;
	}

	public void setJetDiaInch(BigDecimal jetDiaInch) {
		this.jetDiaInch = jetDiaInch;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public BigDecimal getMaxPressPsi() {
		return this.maxPressPsi;
	}

	public void setMaxPressPsi(BigDecimal maxPressPsi) {
		this.maxPressPsi = maxPressPsi;
	}

	public BigDecimal getNoOfGrids() {
		return this.noOfGrids;
	}

	public void setNoOfGrids(BigDecimal noOfGrids) {
		this.noOfGrids = noOfGrids;
	}

	public BigDecimal getNoOfTimepsteps() {
		return this.noOfTimepsteps;
	}

	public void setNoOfTimepsteps(BigDecimal noOfTimepsteps) {
		this.noOfTimepsteps = noOfTimepsteps;
	}

	public BigDecimal getPostProdAtPressPsi() {
		return this.postProdAtPressPsi;
	}

	public void setPostProdAtPressPsi(BigDecimal postProdAtPressPsi) {
		this.postProdAtPressPsi = postProdAtPressPsi;
	}

	public BigDecimal getPostProdBbls() {
		return this.postProdBbls;
	}

	public void setPostProdBbls(BigDecimal postProdBbls) {
		this.postProdBbls = postProdBbls;
	}

	public BigDecimal getRockDensityKg() {
		return this.rockDensityKg;
	}

	public void setRockDensityKg(BigDecimal rockDensityKg) {
		this.rockDensityKg = rockDensityKg;
	}

	public String getStimulationType() {
		return this.stimulationType;
	}

	public void setStimulationType(String stimulationType) {
		this.stimulationType = stimulationType;
	}

	public BigDecimal getTubFrictionCoff() {
		return this.tubFrictionCoff;
	}

	public void setTubFrictionCoff(BigDecimal tubFrictionCoff) {
		this.tubFrictionCoff = tubFrictionCoff;
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