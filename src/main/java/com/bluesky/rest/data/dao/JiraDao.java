package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Jira;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class JiraDao extends GenericDao<Jira, Integer> {

	
	/**
	 * Constructor
	 */
	public JiraDao() {
		super(Jira.class);
	}

}