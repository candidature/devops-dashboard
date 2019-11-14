package com.broadcom.devopsd.dao;

import java.util.List;

import com.broadcom.devopsd.entity.Tool;

public interface ToolDao {
	public List<Tool> getTools();

	public void saveTool(Tool tool);

	public Tool getTool(int toolId);

}
