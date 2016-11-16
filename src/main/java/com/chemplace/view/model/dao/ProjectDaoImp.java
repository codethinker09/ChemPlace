package com.chemplace.view.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemplace.view.model.beans.ModuleSubmoduleTbl;
import com.chemplace.view.model.beans.ProjectTbl;
@Repository
@Transactional
public class ProjectDaoImp implements ProjectDao{
	
	 
	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public int save(ProjectTbl projectTbl) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
	 
		int  projectid =(Integer) session.save(projectTbl);
		 
		return projectid;
	}

	@Override
	public List<ProjectTbl> getProjectDetail(int projectid) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		String hql = "FROM ProjectTbl p WHERE p.projectId =:projectid";
		 
		Query query = session.createQuery(hql);
		 
		query.setParameter("projectid", projectid);
		
		List<ProjectTbl> lib =query.list();
        return lib;
	}

	@Override
	public List<ProjectTbl> getProjectList() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql = "FROM ProjectTbl";
		 
		Query query = session.createQuery(hql);
		
		List<ProjectTbl> PROJECTLIST =query.list();
        return PROJECTLIST;
	}

	
	
}
