package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Jbar;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class JbarDao extends GenericDao<Jbar, Integer> {

	
	/**
	 * Constructor
	 */
	public JbarDao() {
		super(Jbar.class);
	}

}