package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.AcidInjectionTbl;
import com.chemplace.view.model.beans.ReservoirlethologyTbl;

@Transactional
@Repository
public class AcidInjectionTblDaoImp implements AcidInjectionTblDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(List<AcidInjectionTbl> acidinjectdatalist) {
		// TODO Auto-generated method stub
		AcidInjectionTbl acidInjectionTbl[] =new AcidInjectionTbl[10];
		for(int i=0; i<acidinjectdatalist.size(); i++)
		{
			 
			acidInjectionTbl[i]=acidinjectdatalist.get(i);
			sessionFactory.getCurrentSession().save(acidInjectionTbl[i]);
			
			 
		}
	}

	@Override
	public List<AcidInjectionTbl> getlistData(int projectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql = "from AcidInjectionTbl as e where e.projectTbl.projectId=:projectid";
		 
		Query query = session.createQuery(hql);
		
		//Query query = session.createSQLQuery(sql); 
		query.setParameter("projectid", projectid);
		
		List<AcidInjectionTbl> listdata =query.list();
        return listdata;
	}

	@Override
	public void update(List<AcidInjectionTbl> acidinjectdatalist) {
		// TODO Auto-generated method stub
		AcidInjectionTbl acidInjectionTbl[] =new AcidInjectionTbl[acidinjectdatalist.size()];
		
		int k=0;
		for(int i=0; i<acidinjectdatalist.size(); i++)
		{
			 
			acidInjectionTbl[i]=acidinjectdatalist.get(i);
			  System.out.println("fetch entity class from table" +acidInjectionTbl[i]);
			  Session session=sessionFactory.getCurrentSession();
			    
			  // Query hql= session.createQuery("select l.reservoirlethologyId from ReservoirlethologyTbl l where l.projectTbl=:tlb ").setParameter("tlb",reservoirlethologyTbl[i].getProjectTbl() );
			 if(k==0)
			 {
			  Query hql= session.createQuery("delete from AcidInjectionTbl l where l.projectTbl=:tlb ").setParameter("tlb",acidInjectionTbl[i].getProjectTbl() );
			  int result=(int) hql.executeUpdate();
			   System.out.println("safsaf"+result);
			 k++;
			 }  
		  System.out.println("set one class to second "+ acidInjectionTbl[i]);
				
		   session.save( acidInjectionTbl[i]);
			
			
 			
			 
		}
	}

}
