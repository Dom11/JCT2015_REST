package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * The persistent class for the environment database table.
 * 
 */
@Entity
@Table(name="environment")
public class Environment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	
	@Id
	@Column(name="environment_id")
	int environmentId;
	
	@Column(name="environmentName")
	String environmentName;

	
	public Environment() {
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getEnvironmentId() {
		return this.environmentId;
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
}