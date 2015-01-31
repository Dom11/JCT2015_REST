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

	@Id
	@Column(name="jbar_id")
	private int jbarId;

	@Column(name="jbarName")
	private String jbarName;
	
	@Version
	@Column(name="version")
	private Integer version;

	
	public Jbar() {
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

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}