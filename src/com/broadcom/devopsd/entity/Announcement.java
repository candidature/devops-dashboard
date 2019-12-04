package com.broadcom.devopsd.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="details")
	private String details; // 512 characters.
	
	@Enumerated(EnumType.STRING)
	@Column(name="kind", length=10)
	private Kind kind = Kind.PLANNED; // PLANNED | UNPLANNED
	
	@Enumerated(EnumType.STRING)
	@Column(name="criticality", length= 10)
	private Criticality criticality = Criticality.LOW; // NORMAL | CRITICAL
	
	
	
	@Column(name="supported_by_emails")
	private String supportedByEmails;
	
	@Column(name="created_by_emails")
	private String createdByEmail;
	
	@Column(name = "date_of_creation")
	private Date creationDate = new Date();
	
	@Column(name="send_email_to")
	private String send_email_to = null;
	
	

	@Column(name = "start_date")
	private Date startDate = new Date();;
	
	
	@Column(name = "end_date")
	private Date endDate = new Date();;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE})
	private Tool tool;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ToolInstance toolInstance;
	
	
	@Column(name="active")
	private boolean active = true;
	
	public Announcement() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public Criticality getCriticality() {
		return criticality;
	}

	public void setCriticality(Criticality criticality) {
		this.criticality = criticality;
	}

	public String getSupportedByEmails() {
		return supportedByEmails;
	}

	public void setSupportedByEmails(String supportedByEmails) {
		this.supportedByEmails = supportedByEmails;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSend_email_to() {
		return send_email_to;
	}

	public void setSend_email_to(String send_email_to) {
		this.send_email_to = send_email_to;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public ToolInstance getToolInstance() {
		return toolInstance;
	}

	public void setToolInstance(ToolInstance toolInstance) {
		this.toolInstance = toolInstance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", subject=" + subject + ", details=" + details + ", kind=" + kind
				+ ", criticality=" + criticality + ", supportedByEmails=" + supportedByEmails + ", createdByEmail="
				+ createdByEmail + ", creationDate=" + creationDate + ", send_email_to=" + send_email_to
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", tool=" + tool + ", toolInstance="
				+ toolInstance + ", active=" + active + "]";
	}

	public Announcement(String subject, String details, Kind kind, Criticality criticality, String supportedByEmails,
			String createdByEmail, Date creationDate, String send_email_to, Date startDate, Date endDate, Tool tool,
			ToolInstance toolInstance, boolean active) {
		super();
		this.subject = subject;
		this.details = details;
		this.kind = kind;
		this.criticality = criticality;
		this.supportedByEmails = supportedByEmails;
		this.createdByEmail = createdByEmail;
		this.creationDate = creationDate;
		this.send_email_to = send_email_to;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tool = tool;
		this.toolInstance = toolInstance;
		this.active = active;
	}

	
	
	
	
	
	
}
