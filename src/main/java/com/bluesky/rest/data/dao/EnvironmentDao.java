package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Environment;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class EnvironmentDao extends GenericDao<Environment, Integer> {

	
	/**
	 * Constructor
	 */
	public EnvironmentDao() {
		super(Environment.class);
	}

}