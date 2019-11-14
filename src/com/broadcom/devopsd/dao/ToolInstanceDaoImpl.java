package com.broadcom.devopsd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.broadcom.devopsd.entity.ToolInstance;

@Repository
public class ToolInstanceDaoImpl implements ToolInstanceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveToolInstance(ToolInstance toolInstance) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(toolInstance);
	}

}
