package com.chemplace.view.model.dao;

import java.util.Date;

public interface LicenceKeyDao {


	boolean getLicenceKey(String licencekey);
	
	boolean isLiceseExpire();
	
	void updateDate(String licenceno,Date startDate,Date endDate);
	
	
}
