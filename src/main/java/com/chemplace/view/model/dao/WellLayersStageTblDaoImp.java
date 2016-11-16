package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;
@Transactional
@Repository
public class WellLayersStageTblDaoImp implements WellLayersStageTblDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void save(WellLayersStageTbl weLayersStageTbl) {
		
		
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		session.save(weLayersStageTbl);
		
		
		
	}


	@Override
	public List<WellLayersStageTbl> getRowdata(int projectid) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		String hql = "from WellLayersStageTbl as e where e.projectTbl.projectId=:projectid";
		 
		Query query = session.createQuery(hql);
		
		//Query query = session.createSQLQuery(sql); 
		query.setParameter("projectid", projectid);
		
		List<WellLayersStageTbl> listdata =query.list();
        return listdata;
		
		
	}


	@Override
	public void update(WellLayersStageTbl weLayersStageTbl) {
		// TODO Auto-generated method stub
	    Session session=sessionFactory.getCurrentSession();
	    
	   Query hql= session.createQuery("select l.locseqId from WellLayersStageTbl l where l.projectTbl=:tlb ").setParameter("tlb",weLayersStageTbl.getProjectTbl() );
	   int result=(int) hql.uniqueResult();
	   System.out.println("safsaf"+result);
		WellLayersStageTbl wellLayersStage=(WellLayersStageTbl) session.get(WellLayersStageTbl.class,result);
		
		System.out.println("fetch entity class from table" +wellLayersStage);
				
		wellLayersStage.setLocseqId(result);
		if(weLayersStageTbl.getCreateDate() != null)
		wellLayersStage.setCreateDate(weLayersStageTbl.getCreateDate());
		if(weLayersStageTbl.getLastUpdate() != null)
		wellLayersStage.setLastUpdate(weLayersStageTbl.getLastUpdate());
		
		wellLayersStage.setNoOfLayers(weLayersStageTbl.getNoOfLayers());
		wellLayersStage.setNoOfStages(weLayersStageTbl.getNoOfStages());
		wellLayersStage.setProjectTbl(weLayersStageTbl.getProjectTbl());
		if(weLayersStageTbl.getUserId() != null)
		wellLayersStage.setUserId(weLayersStageTbl.getUserId());
		wellLayersStage.setWellName(weLayersStageTbl.getWellName());
		System.out.println("set one class to second "+wellLayersStage);
		
		session.update(wellLayersStage);
	
	}

}
