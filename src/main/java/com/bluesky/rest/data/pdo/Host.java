package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@Table(name="host")
public class Host implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	
	@Id
	@Column(name="host_id")
	private int hostId;

	@Column(name="hostName")
	private String hostName;

	
	public Host() {
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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
}