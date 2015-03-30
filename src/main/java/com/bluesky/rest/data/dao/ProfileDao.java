package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Profile;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class ProfileDao extends GenericDao<Profile, Integer> {

	
	/**
	 * Constructor
	 */
	public ProfileDao() {
		super(Profile.class);
	}

}