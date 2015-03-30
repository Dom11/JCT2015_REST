package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the jira database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="jira")
public class Jira implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="jira_id")
	private int jiraId;

	@Column(name="jiraProjectKey")
	private String jiraProjectKey;

	@Version
	@Column(name="version")
	private Integer version;
	
	
	/**
	 * Constructor
	 */
	public Jira() {
	}
	
	
	// ---- Getter and Setter ----
	
	public int getJiraId() {
		return this.jiraId;
	}
	

	public void setJiraId(int jiraId) {
		this.jiraId = jiraId;
	}

	
	public String getJiraProjectKey() {
		return this.jiraProjectKey;
	}

	
	public void setJiraProjectKey(String jiraProjectKey) {
		this.jiraProjectKey = jiraProjectKey;
	}

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}