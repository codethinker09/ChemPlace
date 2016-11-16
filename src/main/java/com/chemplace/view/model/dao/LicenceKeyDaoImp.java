package com.chemplace.view.model.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.LicenseKeyTbl;

@Repository
@Transactional
public class LicenceKeyDaoImp implements LicenceKeyDao{

	    @Autowired
	    private SessionFactory sessionFactory;
	   
	    @Override
		public boolean getLicenceKey(String licencekey) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 org.hibernate.Query query=  session.createQuery("from LicenseKeyTbl where licenseKey=?");

		LicenseKeyTbl licenseKeyTbl=(LicenseKeyTbl)query.setString(0,licencekey).uniqueResult();
		if(licenseKeyTbl==null){
		  
		System.out.println("Not Valid licence key");
		return false;
		 
		}
		else
		{
		System.out.println("valid licence key");
		return true;
		 
		  
		} 
		
	}

		@Override
		public void updateDate(String licenceno, Date startDate, Date endDate) {
			// TODO Auto-generated method stub
			 Session session = sessionFactory.getCurrentSession();
			 String hql = "UPDATE LicenseKeyTbl set start_lic_date = :start_lic_date,end_lic_date =:end_lic_date,statusLic =:status"  + 
		             " WHERE license_key = :license_key";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter("start_lic_date", startDate);
		query.setParameter("end_lic_date", endDate);
		query.setParameter("license_key", licenceno);
		query.setParameter("status", "Active");
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
			
		}

		@Override
		public boolean isLiceseExpire() {
			// TODO Auto-generated method stub
			
			 Session session = sessionFactory.getCurrentSession();
			// org.hibernate.Query query=  session.createQuery("select count(*) from user_tbl a INNER JOIN license_key_tbl b on a.user_id =b.user_id and a.licensekey =b.license_key and b.end_lic_date >= now()");
             
			// org.hibernate.Query query=  session.createQuery(" select count(*) from UserTbl a ,LicenseKeyTbl b where  a.licenseKey =b.licenseKey and b.endLicDate >= now()");
             
			 org.hibernate.Query query=  session.createQuery(" select count(*) from LicenseKeyTbl  where endLicDate >=now() and statusLic='Active'");

			 //org.hibernate.Query query=  session.createQuery("select count(*) from LicenseKeyTbl b where b.endLicDate >= current_date");
	            
			
			 
			 long i=(long) query.uniqueResult();
			 
			 System.out.println("runningggg= "+i);
			
			 if(i==0)
			 {
				 return false;
				
			 }
			 else
			 {
				 return true;
			 }
		}

		 
		 

		 

}
