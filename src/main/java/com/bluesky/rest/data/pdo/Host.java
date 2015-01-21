package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@Table(name="host")
@NamedQuery(name="Host.findAll", query="SELECT h FROM Host h")
public class Host implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="host_id", unique=true, nullable=false)
	private int hostId;

	@Column(nullable=false, length=20)
	private String hostName;

	public Host() {
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