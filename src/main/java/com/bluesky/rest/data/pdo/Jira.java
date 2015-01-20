package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jira database table.
 * 
 */
@Entity
@Table(name="jira")
@NamedQuery(name="Jira.findAll", query="SELECT j FROM Jira j")
public class Jira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="jira_id", unique=true, nullable=false)
	private int jiraId;

	@Column(nullable=false, length=45)
	private String jiraProjectKey;

	public Jira() {
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