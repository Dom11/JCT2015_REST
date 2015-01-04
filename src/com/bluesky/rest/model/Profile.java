package com.bluesky.rest.model;

import java.io.Serializable;

public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private String description;

	private String environment;

	public Profile() {

	}

	public Profile(int id, String name, String description, String environment) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.environment = environment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptoin) {
		this.description = descriptoin;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
