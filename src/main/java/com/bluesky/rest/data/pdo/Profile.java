package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the profile database table.
 * 
 * @author Dominik
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
	
	@Column(name="domain_id")
	private int domainId;

	@Column(name="profileComponent")
	private String profileComponent;
	
	@Column(name="profileDescription")
	private String profileDescription;
	
	@Column(name="profileDnsName")
	private String profileDnsName;
	
	@Column(name="jvm_id")
	private int jvmId;	
	
	@Column(name="profileStatus")
	private boolean profileStatus;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="rpmGenerationDate")
	private Date rpmGenerationDate;
	
	@Column(name="packageSentDate")
	private Date packageSentDate;	
	
	@Version
	@Column(name="version")
	private Integer version;
	
	
	/**
	 * Constructor
	 */
	public Profile() {
	}
	
	
	// ---- Getter and Setter ----
	
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

	
	public int getDomainId() {
		return this.domainId;
	}

	
	public void setDomainId(int domainId) {
		this.domainId = domainId;
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

	
	public int getJvmId() {
		return this.jvmId;
	}

	
	public void setJvmId(int jvmId) {
		this.jvmId = jvmId;
	}	

	
	public boolean getProfileStatus() {
		return this.profileStatus;
	}

	
	public void setProfileStatus(boolean profileStatus) {
		this.profileStatus = profileStatus;
	}

	
	public String getCreatedBy() {
		return this.createdBy;
	}

	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public Date getRpmGenerationDate() {
		return this.rpmGenerationDate;
	}

	
	public void setRpmGenerationDate(Date rpmGenerationDate) {
		this.rpmGenerationDate = rpmGenerationDate;
	}

	
	public Date getPackageSentDate() {
		return this.packageSentDate;
	}

	
	public void setPackageSentDate(Date packageSentDate) {
		this.packageSentDate = packageSentDate;
	}	

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}