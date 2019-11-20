package com.broadcom.devopsd.service;

import java.util.List;

import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

public interface DevopsService {
	public List<Tool> getTools();

	public void saveTool(Tool tool);

	public Tool getTool(int toolId);

	public void saveInstance(ToolInstance tool);

	public List<ToolInstance> getInstances(int toolId);
	
	public List<ToolInstance> getInstances();

	public List<Tool> getToolsByTier(String tier);

	public void deleteTool(int toolId);

	public ToolInstance getInstance(int instanceId);

	public void saveToolInstance(ToolInstance toolInstance);

	public void deleteToolInstance(int instanceId);
	
}
