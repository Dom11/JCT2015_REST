package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Host;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class HostDao extends GenericDao<Host, Integer> {

	// ---- Fields

	// ---- Constructors
	public HostDao() {
		super(Host.class);
	}
	
	// ---- Methods

}