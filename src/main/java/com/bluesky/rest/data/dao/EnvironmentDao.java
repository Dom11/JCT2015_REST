package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Environment;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class EnvironmentDao extends GenericDao<Environment, Integer> {

	// ---- Fields

	// ---- Constructors
	public EnvironmentDao() {
		super(Environment.class);
	}
	
	// ---- Methods

}