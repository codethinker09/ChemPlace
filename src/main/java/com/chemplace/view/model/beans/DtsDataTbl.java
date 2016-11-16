package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the dts_data_tbl database table.
 * 
 */
@Entity
@Table(name="dts_data_tbl")
@NamedQuery(name="DtsDataTbl.findAll", query="SELECT d FROM DtsDataTbl d")
public class DtsDataTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dts_id")
	private Integer dtsId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="dts_depth_ft")
	private BigDecimal dtsDepthFt;

	@Column(name="dts_temp_0c")
	private BigDecimal dtsTemp0c;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public DtsDataTbl() {
	}

	public Integer getDtsId() {
		return this.dtsId;
	}

	public void setDtsId(Integer dtsId) {
		this.dtsId = dtsId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getDtsDepthFt() {
		return this.dtsDepthFt;
	}

	public void setDtsDepthFt(BigDecimal dtsDepthFt) {
		this.dtsDepthFt = dtsDepthFt;
	}

	public BigDecimal getDtsTemp0c() {
		return this.dtsTemp0c;
	}

	public void setDtsTemp0c(BigDecimal dtsTemp0c) {
		this.dtsTemp0c = dtsTemp0c;
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

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}