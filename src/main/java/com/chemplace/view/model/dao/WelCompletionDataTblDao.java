package com.chemplace.view.model.dao;

 import java.util.List;

import com.chemplace.view.model.beans.WelCompletionDataTbl;

public interface WelCompletionDataTblDao {
	
	public void save(WelCompletionDataTbl welCompletionDataTbl);
	
	public void update(WelCompletionDataTbl welCompletionDataTbl);
	
    public List<WelCompletionDataTbl> getListData(int projectid);
}
