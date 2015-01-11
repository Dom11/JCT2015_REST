package com.bluesky.rest.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Profile implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int id;
	private StringProperty description;
	private StringProperty hostName;
	private StringProperty instance;
	private StringProperty environment;
	private StringProperty domain;
	private StringProperty jBarName;
	

	/**
	 * Default constructor.
	 */
	public Profile() {
		this(0, null, null);
	}
	
	
	/**
	 * Constructor with some default data.
	 * 
	 * @param description
	 * @param envirnoment
	 */
	public Profile(int id, String description, String environment) {
		this.id = id;
		this.description = new SimpleStringProperty(description);
		this.environment = new SimpleStringProperty(environment);		
		
		// Some initial dummy data, just for testing purposes.
		this.hostName = new SimpleStringProperty("srp0433lx");
		this.instance = new SimpleStringProperty("JB1");
		this.domain = new SimpleStringProperty("ZH");
		this.jBarName = new SimpleStringProperty("ESD");
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public String getDescription() {
		return description.get();
	}	
	
	public void setDescription(String description) {
		this.description.set(description);
	}

	public StringProperty descriptionProperty() {
		return description;
	}
	
	public String getHostName() {
		return hostName.get();
	}
	
	public void setHostName(String hostName) {
		this.hostName.set(hostName);
	}
	
	public StringProperty hostNameProperty() {
		return hostName;
	}

	public String getInstance() {
		return instance.get();
	}
	
	public void setInstance(String instance) {
		this.instance.set(instance);
	}
	
	public StringProperty instanceProperty() {
		return instance;
	}

	public String getEnvironment() {
		return environment.get();
	}
	
	public void setEnvironment(String environment) {
		this.environment.set(environment);
	}
	
	public StringProperty environmentProperty() {
		return environment;
	}

	public String getDomain() {
		return domain.get();
	}
	
	public void setDomain(String domain) {
		this.domain.set(domain);
	}
	
	public StringProperty domainProperty() {
		return domain;
	}

	public String getJBarName() {
		return jBarName.get();
	}
	
	public void setJBarName(String jBarName) {
		this.jBarName.set(jBarName);
	}
	
	public StringProperty jBarNameProperty() {
		return jBarName;
	}
}
