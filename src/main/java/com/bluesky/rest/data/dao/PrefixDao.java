package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Prefix;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class PrefixDao extends GenericDao<Prefix, Integer> {

	
	/**
	 * Constructor
	 */
	public PrefixDao() {
		super(Prefix.class);
	}

}