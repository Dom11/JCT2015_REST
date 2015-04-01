package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the profileView database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="profileview")
@NamedQuery(name="ProfileView.findAll", query="SELECT p FROM ProfileView p")
public class ProfileView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="profile_id")
	private int profileId;

	@Column(name="environmentName")
	private String environmentName;

	@Column(name="hostName")
	private String hostName;

	@Column(name="jbarName")
	private String jbarName;

	@Column(name="jiraProjectKey")
	private String jiraProjectKey;
	
	@Column(name="prefixName")
	private String prefixName;
	
	@Column(name="domainName")
	private String domainName;

	@Column(name="profileComponent")
	private String profileComponent;

	@Column(name="profileDescription")
	private String profileDescription;

	@Column(name="profileDnsName")
	private String profileDnsName;

	@Column(name="profileName")
	private String profileName;
	
	@Column(name="jvmArgument")
	private String jvmArgument;
	
	@Column(name="profileStatus")
	private boolean profileStatus;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="rpmGenerationDate")
	private Date rpmGenerationDate;
	
	@Column(name="packageSentDate")
	private Date packageSentDate;	

	
	/**
	 * Constructor
	 */
	public ProfileView() {
	}

	
	// ---- Getter and Setter ----
	
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
	
	
	public boolean getProfileStatus() {
		return this.profileStatus;
	}
	

	public void setProfileStatus(boolean profileStatus) {
		this.profileStatus = profileStatus;
	}
	
	
	public String getJvmArgument() {
		return this.jvmArgument;
	}

	
	public void setJvmArgument(String jvmArgument) {
		this.jvmArgument = jvmArgument;
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
	
}