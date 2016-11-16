package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the completion_tbl database table.
 * 
 */
@Entity
@Table(name="completion_tbl")
@NamedQuery(name="CompletionTbl.findAll", query="SELECT c FROM CompletionTbl c")
public class CompletionTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="completion_id")
	private Integer completionId;

	@Column(name="completion_perf_end_ft")
	private BigDecimal completionPerfEndFt;

	@Column(name="completion_perf_start_ft")
	private BigDecimal completionPerfStartFt;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to ProjectTbl
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectTbl projectTbl;

	public CompletionTbl() {
	}

	public Integer getCompletionId() {
		return this.completionId;
	}

	public void setCompletionId(Integer completionId) {
		this.completionId = completionId;
	}

	public BigDecimal getCompletionPerfEndFt() {
		return this.completionPerfEndFt;
	}

	public void setCompletionPerfEndFt(BigDecimal completionPerfEndFt) {
		this.completionPerfEndFt = completionPerfEndFt;
	}

	public BigDecimal getCompletionPerfStartFt() {
		return this.completionPerfStartFt;
	}

	public void setCompletionPerfStartFt(BigDecimal completionPerfStartFt) {
		this.completionPerfStartFt = completionPerfStartFt;
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

	public ProjectTbl getProjectTbl() {
		return this.projectTbl;
	}

	public void setProjectTbl(ProjectTbl projectTbl) {
		this.projectTbl = projectTbl;
	}

}