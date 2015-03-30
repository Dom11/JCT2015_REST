package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.ProfileView;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class ProfileViewDao extends GenericDao<ProfileView,Integer> {

	
	/**
	 * Constructor
	 */
	public ProfileViewDao() {
		super(ProfileView.class);
	}
	
}