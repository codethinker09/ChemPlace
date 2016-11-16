package com.chemplace.view.model.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.UserTbl;

@Repository
@Transactional
public class UserDaoImp implements UserDao{

 @Autowired
  private SessionFactory sessionFactory;
  
	@Override
	public int  save(UserTbl userTbl) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		 
		int userid=(Integer) session.save(userTbl);
		 
		return userid;
	}

	@Override
	public void upadate(String licencekey,String userid) {
		// TODO Auto-generated method stub
    Session session=sessionFactory.getCurrentSession();
		
	 String hql = "UPDATE UserTbl set licensekey = :licensekey"  + 
	             " WHERE user_name = :user_name";
	org.hibernate.Query query = session.createQuery(hql); 
	query.setParameter("licensekey", licencekey);
	query.setParameter("user_name", userid);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
		
		
		
	}

	@Override
	public boolean isLoginValid(String username, String password) {
		// TODO Auto-generated method stub
		
		 Session session=sessionFactory.getCurrentSession();
		
		 
		 String hql ="select count(*) from UserTbl where userLoginid=:username" +" and userPassword=:userPassword";
		 org.hibernate.Query query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("userPassword", password);
			 long result=(long) query.uniqueResult();
			System.out.println("Rows affected: " + result);
			 
			if(result==0)
			 {
				 return false;
				
			 }
			 else
			 {
				 return true;
			 }
			
		 
	}

	@Override
	public int isUserExist(String Username) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.getCurrentSession();
		 
		 String hql ="select userId from UserTbl where userName=:username";
		 org.hibernate.Query query = session.createQuery(hql);
			query.setParameter("username", Username);
			
			try{
				int result=(Integer) query.uniqueResult();
				System.out.println("Userid=: " + result);
				
				 return result;
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0; 
			}
			
			
			
		
		 
	}

	@Override
	public String getUsername(int userid) {
		// TODO Auto-generated method stub
		
		 Session session=sessionFactory.getCurrentSession();
		 
		 String hql ="select userName from UserTbl where userId=:userId";
		 org.hibernate.Query query = session.createQuery(hql);
			query.setParameter("userId", userid);
			
			try{
				String  result=(String) query.uniqueResult();
				System.out.println("username=: " + result);
				
				 return result;
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ""; 
			}
			
	}

}
