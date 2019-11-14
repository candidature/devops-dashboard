package com.broadcom.devopsd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tool")
public class Tool {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", unique = true)
	private String name;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	private Tier tier; // Tier-1 , Tier-2
	
	@Column(name="purpose")
	private String purpose; // 512 characters.
	
	@Column(name="supported_by_emails")
	private String supportedByEmails; // Email id's - 512 bytes
	
	
	@Column(name="team_name")
	private String teamName; // Email id's - 64 bytes
	
	@Column(name = "start_date")
	private Date startDate = new Date();
	
	@Column(name="active")
	private boolean active = true;
	
	@Column(name="tool_announicement")
	private String announcement;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="tool", cascade= {CascadeType.PERSIST, CascadeType.DETACH,
										CascadeType.REFRESH, CascadeType.MERGE})
	private List<ToolInstance> instances;

	
	public Tool() {}
	
	
	public void add(ToolInstance toolInstance) {
		if (instances == null) {
			instances = new ArrayList<>();
		}
		instances.add(toolInstance);
		toolInstance.setTool(this);
	}
	
	public List<ToolInstance> getInstances() {
		return instances;
	}



	public void setInstances(List<ToolInstance> instances) {
		this.instances = instances;
	}



	public Tool(String name, Tier tier, String purpose, String supportedByEmails, String teamName) {
		super();
		this.name = name;
		this.tier = tier;
		this.purpose = purpose;
		this.supportedByEmails = supportedByEmails;
		this.teamName = teamName;
	}
	
	
	
	public Tool(String name, Tier tier, String purpose, String supportedByEmails, String teamName, Date startDate,
			boolean active, String announcement, List<ToolInstance> instances) {
		super();
		this.name = name;
		this.tier = tier;
		this.purpose = purpose;
		this.supportedByEmails = supportedByEmails;
		this.teamName = teamName;
		this.startDate = startDate;
		this.active = active;
		this.announcement = announcement;
		//this.instances = instances;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSupportedByEmails() {
		return supportedByEmails;
	}

	public void setSupportedByEmails(String supportedByEmails) {
		this.supportedByEmails = supportedByEmails;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	
	@Override
	public String toString() {
		return "Tool [id=" + id + ", name=" + name + ", tier=" + tier + ", purpose=" + purpose + ", supportedByEmails="
				+ supportedByEmails + ", teamName=" + teamName + ", startDate=" + startDate + ", active=" + active
				+ ", announcement=" + announcement  + "]";
	}
	
	
}
