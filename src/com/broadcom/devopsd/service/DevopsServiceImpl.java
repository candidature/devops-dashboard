package com.broadcom.devopsd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.devopsd.dao.ToolDao;
import com.broadcom.devopsd.dao.ToolInstanceDao;
import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

@Service
public class DevopsServiceImpl implements DevopsService {

	@Autowired
	private ToolDao toolDao;
	
	@Autowired
	private ToolInstanceDao toolInstanceDao;
	
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
}
