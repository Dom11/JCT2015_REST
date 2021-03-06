package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Host;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class HostDao extends GenericDao<Host, Integer> {

	
	/**
	 * Constructor
	 */
	public HostDao() {
		super(Host.class);
	}

}