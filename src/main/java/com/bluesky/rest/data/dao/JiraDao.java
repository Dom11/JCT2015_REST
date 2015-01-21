package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Jira;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class JiraDao extends GenericDao<Jira, Integer> {

	// ---- Fields

	// ---- Constructors
	public JiraDao() {
		super(Jira.class);
	}
	
	// ---- Methods

}