package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the prefix database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="prefix")
public class Prefix implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prefix_id")
	private int prefixId;

	@Column(name="prefixName")
	private String prefixName;
	
	@Version
	@Column(name="version")
	private Integer version;
	
	
	/**
	 * Constructor
	 */
	public Prefix() {
	}
	
	
	// ---- Getter and Setter ----
	
	public int getPrefixId() {
		return this.prefixId;
	}

	
	public void setPrefixId(int prefixId) {
		this.prefixId = prefixId;
	}

	
	public String getPrefixName() {
		return this.prefixName;
	}

	
	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}