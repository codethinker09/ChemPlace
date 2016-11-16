package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the press_rate_tbl database table.
 * 
 */
@Entity
@Table(name="press_rate_tbl")
@NamedQuery(name="PressRateTbl.findAll", query="SELECT p FROM PressRateTbl p")
public class PressRateTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="press_rate_id")
	private Integer pressRateId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="press_rate_depth_ft")
	private BigDecimal pressRateDepthFt;

	@Column(name="press_rate_psi")
	private BigDecimal pressRatePsi;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public PressRateTbl() {
	}

	public Integer getPressRateId() {
		return this.pressRateId;
	}

	public void setPressRateId(Integer pressRateId) {
		this.pressRateId = pressRateId;
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

	public BigDecimal getPressRateDepthFt() {
		return this.pressRateDepthFt;
	}

	public void setPressRateDepthFt(BigDecimal pressRateDepthFt) {
		this.pressRateDepthFt = pressRateDepthFt;
	}

	public BigDecimal getPressRatePsi() {
		return this.pressRatePsi;
	}

	public void setPressRatePsi(BigDecimal pressRatePsi) {
		this.pressRatePsi = pressRatePsi;
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