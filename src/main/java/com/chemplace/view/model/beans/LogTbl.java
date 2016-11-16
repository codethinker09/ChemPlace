package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the log_tbl database table.
 * 
 */
@Entity
@Table(name="log_tbl")
@NamedQuery(name="LogTbl.findAll", query="SELECT l FROM LogTbl l")
public class LogTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="log_id")
	private Integer logId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="log_md_ft")
	private BigDecimal logMdFt;

	@Column(name="log_perm_md")
	private BigDecimal logPermMd;

	@Column(name="log_poro")
	private BigDecimal logPoro;

	@Column(name="log_tvd_ft")
	private BigDecimal logTvdFt;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public LogTbl() {
	}

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
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

	public BigDecimal getLogMdFt() {
		return this.logMdFt;
	}

	public void setLogMdFt(BigDecimal logMdFt) {
		this.logMdFt = logMdFt;
	}

	public BigDecimal getLogPermMd() {
		return this.logPermMd;
	}

	public void setLogPermMd(BigDecimal logPermMd) {
		this.logPermMd = logPermMd;
	}

	public BigDecimal getLogPoro() {
		return this.logPoro;
	}

	public void setLogPoro(BigDecimal logPoro) {
		this.logPoro = logPoro;
	}

	public BigDecimal getLogTvdFt() {
		return this.logTvdFt;
	}

	public void setLogTvdFt(BigDecimal logTvdFt) {
		this.logTvdFt = logTvdFt;
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