package com.chemplace.view.model.dao;

import java.util.List;

import com.chemplace.view.model.beans.ReservoirlethologyTbl;

public interface ReservoirlethologyTblDao {
	
	
	public void save(List<ReservoirlethologyTbl> reservoirlethologylist);
	public void update(List<ReservoirlethologyTbl> reservoirlethologylist);
	public List<ReservoirlethologyTbl> getListData(int projectid);
	

}
