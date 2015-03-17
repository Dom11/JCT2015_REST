package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the domain database table.
 * 
 */
@Entity
@Table(name="domain")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="domain_id")
	private int domainId;

	@Column(name="domainName")
	private String domainName;
	
	@Version
	@Column(name="version")
	private Integer version;

	
	public Domain() {
	}

	public int getDomainId() {
		return this.domainId;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}