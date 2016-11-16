package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.AcidInjectionTbl;

public interface AcidInjectionTblDao {
	
	
	public void save(List <AcidInjectionTbl> acidinjectdatalist);
	
	
	public void update(List <AcidInjectionTbl> acidinjectdatalist);
	
	public List<AcidInjectionTbl> getlistData(int projectid);

}
