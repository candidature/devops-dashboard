package com.broadcom.devopsd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.devopsd.dao.AnnouncementDao;
import com.broadcom.devopsd.dao.ToolDao;
import com.broadcom.devopsd.dao.ToolInstanceDao;
import com.broadcom.devopsd.entity.Announcement;
import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

@Service
public class DevopsServiceImpl implements DevopsService {

	@Autowired
	private ToolDao toolDao;
	
	@Autowired
	private ToolInstanceDao toolInstanceDao;
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	
	@Override
	@Transactional
	public List<Tool> getTools() {
		// TODO Auto-generated method stub
		return toolDao.getTools();
	}

	@Override
	@Transactional
	public void saveTool(Tool tool) {
		// TODO Auto-generated method stub
		
		toolDao.saveTool(tool);
		
	}

	@Override
	@Transactional
	public Tool getTool(int toolId) {
		// TODO Auto-generated method stub
		Tool tool = toolDao.getTool(toolId);
		return tool;
	}

	@Override
	@Transactional
	public void saveInstance(ToolInstance toolInstance) {
		toolInstanceDao.saveToolInstance(toolInstance);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<ToolInstance> getInstances(int toolId) {
		// TODO Auto-generated method stub
		return toolInstanceDao.getToolInstances(toolId);
		
	}

	@Override
	@Transactional
	public List<ToolInstance> getInstances() {
		// TODO Auto-generated method stub
		return toolInstanceDao.getToolInstances();
	}

	@Override
	@Transactional
	public List<Tool> getToolsByTier(String tier) {
		// TODO Auto-generated method stub
		return toolDao.getTools(tier);
	}

	@Override
	@Transactional
	public void deleteTool(int toolId) {
		// TODO Auto-generated method stub
		toolDao.deleteTool(toolId);
	}

	@Override
	@Transactional
	public ToolInstance getInstance(int instanceId) {
		// TODO Auto-generated method stub
		return toolInstanceDao.getToolInstance(instanceId);
	}

	@Override
	@Transactional
	public void saveToolInstance(ToolInstance toolInstance) {
		// TODO Auto-generated method stub
		toolInstanceDao.saveToolInstance(toolInstance);
	}

	@Override
	@Transactional
	public void deleteToolInstance(int instanceId) {
		// TODO Auto-generated method stub
		toolInstanceDao.deleteToolInstance(instanceId);
	}

	@Override
	@Transactional
	public void saveAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		announcementDao.saveAnnouncement(announcement);
		
	}

	@Override
	@Transactional
	public List<Announcement> listActiveAnnouncements() {
		// TODO Auto-generated method stub
		
		return announcementDao.listActiveAnnouncements();
		
		
	}

	@Override
	@Transactional
	public Announcement getAnnouncement(int announcementId) {
		// TODO Auto-generated method stub
		return announcementDao.getAnnouncement(announcementId);
	}

	@Override
	@Transactional
	public void deleteAnnouncement(int announcementId) {
		// TODO Auto-generated method stub
		announcementDao.deleteAnnouncement(announcementId);
	}

	@Override
	@Transactional
	public List<Announcement> listAllAnnouncements() {
		// TODO Auto-generated method stub
		return announcementDao.listAllAnnouncements();
	}
}
