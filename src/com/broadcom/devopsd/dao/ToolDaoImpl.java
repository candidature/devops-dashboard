package com.broadcom.devopsd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.broadcom.devopsd.entity.Tier;
import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

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
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(tool);
	}


	@Override
	public Tool getTool(int toolId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		Tool tool = session.get(Tool.class, toolId);
		return tool;
	}


	@Override
	public List<Tool> getTools(String tier) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query<Tool> query = session.createQuery("from Tool where tier= :tier order by startDate", Tool.class);
		query.setString("tier", tier);
		List<Tool> tools = query.getResultList();
		return tools;
		
	}


	@Override
	public void deleteTool(int toolId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<ToolInstance> query1 = session.createQuery("from ToolInstance where tool= :toolId order by startDate", ToolInstance.class);
		query1.setInteger("toolId", toolId);
		
		
		List<ToolInstance> toolInstances = query1.getResultList();
		
		if (toolInstances.size() > 0) {
			System.out.println("Can not delete tool because it has many instances...");
			return;
		}
		
		Query query2 = session.createQuery("delete from Tool where id=:toolId");
		
		query2.setParameter("toolId", toolId);
		
		query2.executeUpdate();
		
		//TBIMPLEMENTED----<<<
		
	}

}
