package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profileview database table.
 * 
 */
@Entity
@Table(name="profileview")
@NamedQuery(name="Profileview.findAll", query="SELECT p FROM Profileview p")
public class Profileview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=5)
	private String environmentName;

	@Column(nullable=false, length=20)
	private String hostName;

	@Column(nullable=false, length=5)
	private String jbarName;

	@Column(nullable=false, length=45)
	private String jiraProjectKey;
	
	@Column(nullable=false, length=5)
	private String prefixName;
	
	@Column(nullable=false, length=45)
	private String domainName;
	
	@Id
	@Column(name="profile_id", nullable=false)
	private int profileId;

	@Column(length=45)
	private String profileComponent;

	@Column(length=45)
	private String profileDescription;

	@Column(length=255)
	private String profileDnsName;

	@Column(length=17)
	private String profileName;

	
	public Profileview() {
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getJbarName() {
		return this.jbarName;
	}

	public void setJbarName(String jbarName) {
		this.jbarName = jbarName;
	}
	

	public String getJiraProjectKey() {
		return this.jiraProjectKey;
	}

	public void setJiraProjectKey(String jiraProjectKey) {
		this.jiraProjectKey = jiraProjectKey;
	}

	public String getPrefixName() {
		return this.prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}
	
	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
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

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
}