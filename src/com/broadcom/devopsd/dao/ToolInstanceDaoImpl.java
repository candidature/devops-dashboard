package com.broadcom.devopsd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

@Repository
public class ToolInstanceDaoImpl implements ToolInstanceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveToolInstance(ToolInstance toolInstance) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(toolInstance);
	}
	
	
	@Override
	public List<ToolInstance> getToolInstances() {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		
		
		Query<ToolInstance> query = session.createQuery("from ToolInstance order by startDate", ToolInstance.class);
		List<ToolInstance> toolInstances = query.getResultList();
		
		
		return toolInstances;
	}
	
	
	@Override
	public List<ToolInstance> getToolInstances(int toolId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		
		Query<ToolInstance> query = session.createQuery("from ToolInstance where tool= :toolId order by startDate", ToolInstance.class);
		query.setInteger("toolId", toolId);
		
		
		List<ToolInstance> toolInstances = query.getResultList();
		for (ToolInstance toolInstance: toolInstances) {
			System.out.println(toolInstance);	
		}
		
		return toolInstances;
	}

	

	@Override
	public ToolInstance getToolInstance(int instanceId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ToolInstance toolInstance = session.get(ToolInstance.class, instanceId);
		return toolInstance;
	}

	@Override
	public void deleteToolInstance(int instanceId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from ToolInstance where id=:toolInstanceId");
		
		query.setParameter("toolInstanceId", instanceId);
		
		query.executeUpdate();
		
		
	}

}
