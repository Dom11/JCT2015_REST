package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the environment database table.
 * 
 */
@Entity
@Table(name="environment")
@NamedQuery(name="Environment.findAll", query="SELECT e FROM Environment e")
public class Environment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="environment_id", unique=true, nullable=false)
	private int environmentId;

	@Column(nullable=false, length=5)
	private String environmentName;

	public Environment() {
	}

	public int getEnvironmentId() {
		return this.environmentId;
	}

	public void setEnvironmentId(int environmentId) {
		this.environmentId = environmentId;
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

}