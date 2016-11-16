package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.ProjectTbl;

public interface ProjectDao {
	
	public int save(ProjectTbl projectTbl);
	
	public List<ProjectTbl> getProjectDetail(int projectid);
	
	
	public List<ProjectTbl> getProjectList();

}
