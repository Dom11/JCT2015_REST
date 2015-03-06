package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.ProfileView;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class ProfileViewDao extends GenericDao<ProfileView,Integer> {

	// ---- Fields

	// ---- Constructors
	public ProfileViewDao() {
		super(ProfileView.class);
	}

	// ---- Methods
	
}