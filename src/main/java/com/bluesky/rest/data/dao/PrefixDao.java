package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Prefix;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class PrefixDao extends GenericDao<Prefix, Integer> {

	// ---- Fields

	// ---- Constructors
	public PrefixDao() {
		super(Prefix.class);
	}
	
	// ---- Methods

}