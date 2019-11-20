package com.broadcom.devopsd.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	
	@Column(name="kind")
	private String kind; // INFO | DISRUPTIVE |  
	
	@Column(name="supported_by_emails")
	private String supportedByEmails;
	
	@Column(name="created_by_emails")
	private String createdByEmail;
	
	@Column(name = "date_of_creation")
	private Date creationDate = new Date();
	
	@Column(name="send_email_to")
	private String send_email_to = null;
	
	
	
	@Column(name = "start_date")
	private Date startDate = new Date();
	
	
	@Column(name = "end_date")
	private Date endDate;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name="tool_id")
	private Tool tool;
	
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name="instance_id")
	private ToolInstance toolInstance;
	
	
	@Column(name="active")
	private boolean active = true;
	
	public Announcement() {
		// TODO Auto-generated constructor stub
	}
	
}
