package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the module_submodule_tbl database table.
 * 
 */
@Entity
@Table(name="module_submodule_tbl")
@NamedQuery(name="ModuleSubmoduleTbl.findAll", query="SELECT m FROM ModuleSubmoduleTbl m")
public class ModuleSubmoduleTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="module_subm_id")
	private Integer moduleSubmId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="module_id")
	private Integer moduleId;

	@Column(name="module_name")
	private String moduleName;

	@Column(name="sub_module_id")
	private Integer subModuleId;

	//bi-directional many-to-one association to ProjectTbl
	@OneToMany(mappedBy="moduleSubmoduleTbl")
	private List<ProjectTbl> projectTbls;

	public ModuleSubmoduleTbl() {
	}

	public Integer getModuleSubmId() {
		return this.moduleSubmId;
	}

	public void setModuleSubmId(Integer moduleSubmId) {
		this.moduleSubmId = moduleSubmId;
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

	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getSubModuleId() {
		return this.subModuleId;
	}

	public void setSubModuleId(Integer subModuleId) {
		this.subModuleId = subModuleId;
	}

	public List<ProjectTbl> getProjectTbls() {
		return this.projectTbls;
	}

	public void setProjectTbls(List<ProjectTbl> projectTbls) {
		this.projectTbls = projectTbls;
	}

	public ProjectTbl addProjectTbl(ProjectTbl projectTbl) {
		getProjectTbls().add(projectTbl);
		projectTbl.setModuleSubmoduleTbl(this);

		return projectTbl;
	}

	public ProjectTbl removeProjectTbl(ProjectTbl projectTbl) {
		getProjectTbls().remove(projectTbl);
		projectTbl.setModuleSubmoduleTbl(null);

		return projectTbl;
	}

}