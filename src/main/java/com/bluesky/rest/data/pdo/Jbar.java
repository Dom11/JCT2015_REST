package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jbar database table.
 * 
 */
@Entity
@Table(name="jbar")
@NamedQuery(name="Jbar.findAll", query="SELECT j FROM Jbar j")
public class Jbar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="jbar_id", unique=true, nullable=false)
	private int jbarId;

	@Column(nullable=false, length=5)
	private String jbarName;

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

}