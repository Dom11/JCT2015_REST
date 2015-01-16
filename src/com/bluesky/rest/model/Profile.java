package com.bluesky.rest.model;

import java.io.Serializable;

public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String description;
	private String hostName;
	private String instance;
	private String environment;
	private String domain;
	private String jBarName;

	/**
	 * Constructor with some default data.
	 * 
	 * @param description
	 * @param envirnoment
	 */
	public Profile(int id, String description, String environment) {
		this.id = id;
		this.description = description;
		this.environment = environment;

		// Some initial dummy data, just for testing purposes.
		this.hostName = "srp0433lx";
		this.instance = "JB1";
		this.domain = "ZH";
		this.jBarName = "ESD";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getjBarName() {
		return jBarName;
	}

	public void setjBarName(String jBarName) {
		this.jBarName = jBarName;
	}

}
