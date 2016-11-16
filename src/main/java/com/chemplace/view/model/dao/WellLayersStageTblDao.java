package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;

public interface WellLayersStageTblDao {
	
	public void save(WellLayersStageTbl weLayersStageTbl);
	
	public void update(WellLayersStageTbl weLayersStageTbl);
	
	public List<WellLayersStageTbl> getRowdata(int projectid);
	

}
