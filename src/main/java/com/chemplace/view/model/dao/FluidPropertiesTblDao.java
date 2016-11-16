package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.FluidPropertiesTbl;

public interface FluidPropertiesTblDao {
	
	public void save(FluidPropertiesTbl fluidPropertiesTbl);
	public void update(FluidPropertiesTbl fluidPropertiesTbl);
	
	public List<FluidPropertiesTbl> getListData(int projectid);
	
	

}
