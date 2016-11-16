package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.AdditionalInpuDataTbl;
import com.chemplace.view.model.beans.FluidPropertiesTbl;
@Repository
@Transactional
public class FluidPropertiesTblDaoImp implements FluidPropertiesTblDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(FluidPropertiesTbl fluidPropertiesTbl) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(fluidPropertiesTbl);
	}

	@Override
	public List<FluidPropertiesTbl> getListData(int projectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql = "from FluidPropertiesTbl as e where e.projectTbl.projectId=:projectid";
		 
		Query query = session.createQuery(hql);
		
		//Query query = session.createSQLQuery(sql); 
		query.setParameter("projectid", projectid);
		
		List<FluidPropertiesTbl> listdata =query.list();
        return listdata;
	}

	@Override
	public void update(FluidPropertiesTbl fluidPropertiesTbl) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	    
		  // Query hql= session.createQuery("select l.reservoirlethologyId from ReservoirlethologyTbl l where l.projectTbl=:tlb ").setParameter("tlb",reservoirlethologyTbl[i].getProjectTbl() );
		 
		   Query hql= session.createQuery("delete from FluidPropertiesTbl l where l.projectTbl=:tlb ").setParameter("tlb", fluidPropertiesTbl.getProjectTbl() );
		   int result=(int) hql.executeUpdate();
		   System.out.println("safsaf"+result);
		   System.out.println("set one class to second "+ fluidPropertiesTbl);
	       session.save(fluidPropertiesTbl);
	}

}
