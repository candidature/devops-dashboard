package com.broadcom.devopsd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.broadcom.devopsd.entity.Announcement;
import com.broadcom.devopsd.entity.Tool;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void saveAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(announcement);
	}

	

	@Override
	public List<Announcement> listActiveAnnouncements() {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		Query<Announcement> query = session.createQuery("from Announcement where active=1 and tool = null", Announcement.class);
		List<Announcement> announcements = query.getResultList();
		return announcements;
	}



	@Override
	public Announcement getAnnouncement(int announcementId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Announcement announcement = session.get(Announcement.class, announcementId);
		return announcement;
	}



	@Override
	public void deleteAnnouncement(int announcementId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Announcement announcement = session.get(Announcement.class, announcementId);
		session.delete(announcement);
	}



	@Override
	public List<Announcement> listAllAnnouncements() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query<Announcement> query = session.createQuery("from Announcement", Announcement.class);
		
		List<Announcement> announcements = query.getResultList();
		return announcements;
	}

}
