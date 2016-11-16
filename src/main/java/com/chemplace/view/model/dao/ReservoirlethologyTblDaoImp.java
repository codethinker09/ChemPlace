package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.ReservoirlethologyTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;


@Transactional
@Repository
public class ReservoirlethologyTblDaoImp implements ReservoirlethologyTblDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void save(List<ReservoirlethologyTbl> reservoirlethologylist) {
		// TODO Auto-generated method stub
		ReservoirlethologyTbl reservoirlethologyTbl[] =new ReservoirlethologyTbl[reservoirlethologylist.size()];
		for(int i=0; i<reservoirlethologylist.size(); i++)
		{
			 
			reservoirlethologyTbl[i]=reservoirlethologylist.get(i);
			sessionFactory.getCurrentSession().save(reservoirlethologyTbl[i]);
			
			 
		}
		
	}


	@Override
	public List<ReservoirlethologyTbl> getListData(int projectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql = "from ReservoirlethologyTbl as e where e.projectTbl.projectId=:projectid";
		 
		Query query = session.createQuery(hql);
		
		//Query query = session.createSQLQuery(sql); 
		query.setParameter("projectid", projectid);
		
		List<ReservoirlethologyTbl> listdata =query.list();
        return listdata;
	}


	@Override
	public void update(List<ReservoirlethologyTbl> reservoirlethologylist) {
		// TODO Auto-generated method stub
		ReservoirlethologyTbl reservoirlethologyTbl[] =new ReservoirlethologyTbl[reservoirlethologylist.size()];
		
		int k=0;
		for(int i=0; i<reservoirlethologylist.size(); i++)
		{
			 
			  reservoirlethologyTbl[i]=reservoirlethologylist.get(i);
			  System.out.println("fetch entity class from table" +reservoirlethologyTbl[i]);
			  Session session=sessionFactory.getCurrentSession();
			    
			  // Query hql= session.createQuery("select l.reservoirlethologyId from ReservoirlethologyTbl l where l.projectTbl=:tlb ").setParameter("tlb",reservoirlethologyTbl[i].getProjectTbl() );
			 if(k==0)
			 {
			  Query hql= session.createQuery("delete from ReservoirlethologyTbl l where l.projectTbl=:tlb ").setParameter("tlb",reservoirlethologyTbl[i].getProjectTbl() );
			  int result=(int) hql.executeUpdate();
			   System.out.println("safsaf"+result);
			 k++;
			 }  
				
						
				 
		    System.out.println("set one class to second "+ reservoirlethologyTbl[i]);
				
		   session.save( reservoirlethologyTbl[i]);
			
			
 			
			 
		}
	}

}
