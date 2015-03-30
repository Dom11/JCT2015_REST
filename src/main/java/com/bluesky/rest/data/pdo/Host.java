package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the host database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="host")
public class Host implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="host_id")
	private int hostId;

	@Column(name="hostName")
	private String hostName;
	
	@Version
	@Column(name="version")
	private Integer version;

	
	/**
	 * Constructor
	 */
	public Host() {
	}

	
	// ---- Getter and Setter ----
	
	public int getHostId() {
		return this.hostId;
	}

	
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	
	public String getHostName() {
		return this.hostName;
	}

	
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}