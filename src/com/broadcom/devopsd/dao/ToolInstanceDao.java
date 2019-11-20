package com.broadcom.devopsd.dao;

import java.util.List;

import com.broadcom.devopsd.entity.ToolInstance;

public interface ToolInstanceDao {
	public void saveToolInstance(ToolInstance toolInstance);

	public List<ToolInstance> getToolInstances(int toolId);
	
	public List<ToolInstance> getToolInstances();

	public ToolInstance getToolInstance(int instanceId);

	public void deleteToolInstance(int instanceId);
}
