package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.ModuleSubmoduleTbl;
 
@Repository
@Transactional
public class ModuleSubModuledaoImp implements ModuleSubModuledao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ModuleSubmoduleTbl> getAllModuleData(int moduleid) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		String hql = "FROM ModuleSubmoduleTbl m WHERE m.moduleSubmId =:moduleid";
		
		 
		
		Query query = session.createQuery(hql);
		
		
		query.setParameter("moduleid", moduleid);
		
		List<ModuleSubmoduleTbl> lib =query.list();
        //List<ModuleSubmoduleTbl> lib = (List<ModuleSubmoduleTbl>)session.createCriteria(ModuleSubmoduleTbl.class).list();
        return lib;
	}

}
