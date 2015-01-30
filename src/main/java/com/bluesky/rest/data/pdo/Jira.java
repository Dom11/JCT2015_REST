package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the jira database table.
 * 
 */
@Entity
@Table(name="jira")
public class Jira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	
	@Id
	@Column(name="jira_id")
	private int jiraId;

	@Column(name="jiraProjectKey")
	private String jiraProjectKey;

	
	public Jira() {
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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
}