package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="profile_id")
	private int profileId;

	@Column(name="environment_id")
	private int environmentId;

	@Column(name="host_id")
	private int hostId;

	@Column(name="jbar_id")
	private int jbarId;

	@Column(name="jira_id")
	private int jiraId;

	@Column(name="prefix_id")
	private int prefixId;

	@Column(name="profileComponent")
	private String profileComponent;
	
	@Column(name="profileDescription")
	private String profileDescription;
	
	@Column(name="profileDnsName")
	private String profileDnsName;
	
	@Version
	@Column(name="version")
	private Integer version;
	
	
	public Profile() {
	}
	
	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getEnvironmentId() {
		return this.environmentId;
	}

	public void setEnvironmentId(int environmentId) {
		this.environmentId = environmentId;
	}

	public int getHostId() {
		return this.hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getJbarId() {
		return this.jbarId;
	}

	public void setJbarId(int jbarId) {
		this.jbarId = jbarId;
	}

	public int getJiraId() {
		return this.jiraId;
	}

	public void setJiraId(int jiraId) {
		this.jiraId = jiraId;
	}

	public int getPrefixId() {
		return this.prefixId;
	}

	public void setPrefixId(int prefixId) {
		this.prefixId = prefixId;
	}

	public String getProfileComponent() {
		return this.profileComponent;
	}

	public void setProfileComponent(String profileComponent) {
		this.profileComponent = profileComponent;
	}

	public String getProfileDescription() {
		return this.profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getProfileDnsName() {
		return this.profileDnsName;
	}

	public void setProfileDnsName(String profileDnsName) {
		this.profileDnsName = profileDnsName;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}