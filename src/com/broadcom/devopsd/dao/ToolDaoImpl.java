package com.broadcom.devopsd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.broadcom.devopsd.entity.Tier;
import com.broadcom.devopsd.entity.Tool;

@Repository
public class ToolDaoImpl implements ToolDao{

	
	//Need to inject hibernate session factory so that DAO impl can use it
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Tool> getTools() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		//Tool tool = new Tool("Jenkins", Tier.TIER_1, 
		//		"Automation - CI and Build System Tool", 
		//		"it_scm@broadcom.com; scm+l2@broadcom.com","DevOps");
		
		
		//session.save(tool);
		//session.getTransaction().commit();
		
		//Session session2 = this.sessionFactory.getCurrentSession();
		
		Query<Tool> query = session.createQuery("from Tool order by name", Tool.class);
		List<Tool> tools = query.getResultList();
		return tools;
	}


	@Override
	public void saveTool(Tool tool) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(tool);
		
	}


	@Override
	public Tool getTool(int toolId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		Tool tool = session.get(Tool.class, toolId);
		return tool;
	}

}
