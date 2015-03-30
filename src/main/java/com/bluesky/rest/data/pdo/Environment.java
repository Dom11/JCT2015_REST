package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the environment database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="environment")
public class Environment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="environment_id")
	private int environmentId;

	@Column(name="environmentName")
	private String environmentName;

	@Version
	@Column(name="version")
	private Integer version;

	
	/**
	 * Constructor
	 */
	public Environment() {
	}
	
	
	// ---- Getter and Setter ----
	
	public int getEnvironmentId() {
		return this.environmentId;
	}

	
	public String getEnvironmentName() {
		return this.environmentName;
	}

	
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}