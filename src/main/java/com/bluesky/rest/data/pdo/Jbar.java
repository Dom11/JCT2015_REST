package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the jbar database table.
 * 
 */
@Entity
@Table(name="jbar")
public class Jbar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	
	@Id
	@Column(name="jbar_id")
	private int jbarId;

	@Column(name="jbarName")
	private String jbarName;

	
	public Jbar() {
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getJbarId() {
		return this.jbarId;
	}

	public void setJbarId(int jbarId) {
		this.jbarId = jbarId;
	}

	public String getJbarName() {
		return this.jbarName;
	}

	public void setJbarName(String jbarName) {
		this.jbarName = jbarName;
	}
}