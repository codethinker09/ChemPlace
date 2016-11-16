package com.chemplace.view.model.dao;

import com.chemplace.view.model.beans.UserTbl;

public interface UserDao {

	
	int save(UserTbl userTbl);
	
	int isUserExist(String Username);
	
	void upadate(String licencekey,String userid);
	
	String getUsername(int userid);
	
	boolean isLoginValid(String username,String password);
	
	
}
