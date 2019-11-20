package com.broadcom.devopsd.dao;

import java.util.List;

import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;

public interface ToolDao {
	public List<Tool> getTools();

	public void saveTool(Tool tool);

	public Tool getTool(int toolId);

	public List<Tool> getTools(String tier);

	public void deleteTool(int toolId);


}
