package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Jbar;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class JbarDao extends GenericDao<Jbar, Integer> {

	// ---- Fields

	// ---- Constructors
	public JbarDao() {
		super(Jbar.class);
	}
	
	// ---- Methods

}