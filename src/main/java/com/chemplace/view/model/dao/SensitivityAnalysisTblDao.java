package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.SensitivityAnalysisTbl;

public interface SensitivityAnalysisTblDao {
	
	public void save(SensitivityAnalysisTbl sensitivityAnalysisTbl);
	
	public void save(List<SensitivityAnalysisTbl> listdata);
	
	public void update(List<SensitivityAnalysisTbl> listdata);
	
	//public List<SensitivityAnalysisTbl> getSensitivityAnalysisTblData(int projectid);

	public List<SensitivityAnalysisTbl> getListdata(int projectid);

	 
}
