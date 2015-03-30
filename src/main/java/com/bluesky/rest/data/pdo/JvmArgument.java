package com.bluesky.rest.data.pdo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the jvmArgument database table.
 * 
 * @author Dominik
 */
@Entity
@Table(name="jvmArgument")
public class JvmArgument implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="jvm_id")
	private int jvmId;

	@Column(name="jvmArgument")
	private String jvmArgument;
	
	@Version
	@Column(name="version")
	private Integer version;

	
	/**
	 * Constructor
	 */
	public JvmArgument() {
	}

	
	// ---- Getter and Setter ----
	
	public int getJvmId() {
		return this.jvmId;
	}

	
	public String getJvmArgument() {
		return this.jvmArgument;
	}

	
	public void setJvmArgument(String jvmArgument) {
		this.jvmArgument = jvmArgument;
	}

	
	public Integer getVersion() {
		return this.version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}