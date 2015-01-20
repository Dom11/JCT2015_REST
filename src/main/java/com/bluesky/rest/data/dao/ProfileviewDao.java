package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Profileview;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class ProfileviewDao extends GenericDao<Profileview,Integer> {

	// ---- Fields

	// ---- Constructors
	public ProfileviewDao() {
		super(Profileview.class);
	}

	// ---- Methods
	
}