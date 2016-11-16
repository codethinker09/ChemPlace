package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.AdditionalInpuDataTbl;

public interface AdditionalInpuDataTblDao {
	
	public void save(AdditionalInpuDataTbl additionalInpuDataTbl);
	
	public void update(AdditionalInpuDataTbl additionalInpuDataTbl);
	
	
	
	
	public List<AdditionalInpuDataTbl> getListData(int projectid);
	

}
