package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Profile;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class ProfileDao extends GenericDao<Profile, Integer> {

	// ---- Fields

	// ---- Constructors
	public ProfileDao() {
		super(Profile.class);
	}
	
	// ---- Methods

}