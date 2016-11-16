package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.SensitivityAnalysisTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;
@Transactional
@Repository
public class SensitivityAnalysisTblDaoImp implements SensitivityAnalysisTblDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(SensitivityAnalysisTbl sensitivityAnalysisTbl) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		
		session.save(sensitivityAnalysisTbl);
		
	}

	@Override
	public void save(List<SensitivityAnalysisTbl> listdata) {
		// TODO Auto-generated method stub
		//Session session=sessionFactory.getCurrentSession();
		SensitivityAnalysisTbl sensitivityAnalysisTbl[] =new SensitivityAnalysisTbl[listdata.size()];
		for(int i=0; i<listdata.size(); i++)
		{
			 
			sensitivityAnalysisTbl[i]=listdata.get(i);
			sessionFactory.getCurrentSession().save(sensitivityAnalysisTbl[i]);
			
			 
		}
		
		
	}

	@Override
	public List<SensitivityAnalysisTbl> getListdata(int projectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql = "from SensitivityAnalysisTbl as e where e.projectTbl.projectId=:projectid";
		 
		Query query = session.createQuery(hql);
		
		//Query query = session.createSQLQuery(sql); 
		query.setParameter("projectid", projectid);
		
		List<SensitivityAnalysisTbl> listdata =query.list();
        return listdata;
	}

	@Override
	public void update(List<SensitivityAnalysisTbl> listdata) {
		// TODO Auto-generated method stub
		SensitivityAnalysisTbl sensitivityAnalysisTbl[] =new SensitivityAnalysisTbl[listdata.size()];
		int k=0;
		for(int i=0; i<listdata.size(); i++)
		{
			sensitivityAnalysisTbl[i]=listdata.get(i);
		  System.out.println("fetch entity class from table" +sensitivityAnalysisTbl[i]);
		  Session session=sessionFactory.getCurrentSession();
		    
		  // Query hql= session.createQuery("select l.reservoirlethologyId from ReservoirlethologyTbl l where l.projectTbl=:tlb ").setParameter("tlb",reservoirlethologyTbl[i].getProjectTbl() );
		 if(k==0)
		 {
		  Query hql= session.createQuery("delete from SensitivityAnalysisTbl l where l.projectTbl=:tlb ").setParameter("tlb",sensitivityAnalysisTbl[i].getProjectTbl() );
		  int result=(int) hql.executeUpdate();
		   System.out.println("safsaf"+result);
		 k++;
		 }  
	   System.out.println("set one class to second "+ sensitivityAnalysisTbl[i]);
	   session.save( sensitivityAnalysisTbl[i]);
			 
		}
	}

	 

	 

	 

	 
}
