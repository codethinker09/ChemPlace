package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the fluid_properties_tbl database table.
 * 
 */
@Entity
@Table(name="fluid_properties_tbl")
@NamedQuery(name="FluidPropertiesTbl.findAll", query="SELECT f FROM FluidPropertiesTbl f")
public class FluidPropertiesTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="flud_id")
	private Integer fludId;

	@Column(name="acid_density_kg_m3")
	private BigDecimal acidDensityKgM3;

	@Column(name="acid_dissolving_power")
	private BigDecimal acidDissolvingPower;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="res_gas_density_kg_m3")
	private BigDecimal resGasDensityKgM3;

	@Column(name="res_gas_vis_cp")
	private BigDecimal resGasVisCp;

	@Column(name="res_oil_density_kg_m3")
	private BigDecimal resOilDensityKgM3;

	@Column(name="res_oil_vis_cp")
	private BigDecimal resOilVisCp;

	@Column(name="res_water_density_kg_m3")
	private BigDecimal resWaterDensityKgM3;

	@Column(name="res_water_visc_cp")
	private BigDecimal resWaterViscCp;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public FluidPropertiesTbl() {
	}

	public Integer getFludId() {
		return this.fludId;
	}

	public void setFludId(Integer fludId) {
		this.fludId = fludId;
	}

	public BigDecimal getAcidDensityKgM3() {
		return this.acidDensityKgM3;
	}

	public void setAcidDensityKgM3(BigDecimal acidDensityKgM3) {
		this.acidDensityKgM3 = acidDensityKgM3;
	}

	public BigDecimal getAcidDissolvingPower() {
		return this.acidDissolvingPower;
	}

	public void setAcidDissolvingPower(BigDecimal acidDissolvingPower) {
		this.acidDissolvingPower = acidDissolvingPower;
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

	public BigDecimal getResGasDensityKgM3() {
		return this.resGasDensityKgM3;
	}

	public void setResGasDensityKgM3(BigDecimal resGasDensityKgM3) {
		this.resGasDensityKgM3 = resGasDensityKgM3;
	}

	public BigDecimal getResGasVisCp() {
		return this.resGasVisCp;
	}

	public void setResGasVisCp(BigDecimal resGasVisCp) {
		this.resGasVisCp = resGasVisCp;
	}

	public BigDecimal getResOilDensityKgM3() {
		return this.resOilDensityKgM3;
	}

	public void setResOilDensityKgM3(BigDecimal resOilDensityKgM3) {
		this.resOilDensityKgM3 = resOilDensityKgM3;
	}

	public BigDecimal getResOilVisCp() {
		return this.resOilVisCp;
	}

	public void setResOilVisCp(BigDecimal resOilVisCp) {
		this.resOilVisCp = resOilVisCp;
	}

	public BigDecimal getResWaterDensityKgM3() {
		return this.resWaterDensityKgM3;
	}

	public void setResWaterDensityKgM3(BigDecimal resWaterDensityKgM3) {
		this.resWaterDensityKgM3 = resWaterDensityKgM3;
	}

	public BigDecimal getResWaterViscCp() {
		return this.resWaterViscCp;
	}

	public void setResWaterViscCp(BigDecimal resWaterViscCp) {
		this.resWaterViscCp = resWaterViscCp;
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