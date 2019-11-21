package com.broadcom.devopsd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tool_instance")
public class ToolInstance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="url")
	private String url;
	
	@Column(name="team")
	private String team;
	
	@Column(name="owner")
	private String owner;
	

	@Column(name = "start_date")
	private Date startDate = new Date();
	
	@Column(name="active")
	private boolean active = true;
	
	private String status = "UNKNOWN"; // DISABLED // GREEN // RED 
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH,
										CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name="tool_id")
	private Tool tool;
	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tool", cascade= {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE})
	private List<Announcement> announcements;
	
	public void add(Announcement announcement) {
		if (announcements == null) {
			announcements = new ArrayList<>();
		}
		announcements.add(announcement);
		announcement.setToolInstance(this);
	}
	
	
	public ToolInstance() { }

	
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public ToolInstance(String url, String team, String owner) {
		super();
		this.url = url;
		this.team = team;
		this.owner = owner;
	}
	
	
	public ToolInstance(String url, String team, String owner, Date startDate, boolean active, String status) {
		super();
		this.url = url;
		this.team = team;
		this.owner = owner;
		this.startDate = startDate;
		this.active = active;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Tool getTool() {
		return tool;
	}

	public void setToolId(Tool toolId) {
		this.tool = tool;
	}



	@Override
	public String toString() {
		return "ToolInstance [id=" + id + ", url=" + url + ", team=" + team + ", owner=" + owner + ", startDate="
				+ startDate + ", active=" + active + ", status=" + status
				+ ", tool=" + tool + "]";
	}
}
