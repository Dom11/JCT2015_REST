package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.JvmArgument;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class JvmArgumentDao extends GenericDao<JvmArgument, Integer> {

	
	/**
	 * Constructor
	 */
	public JvmArgumentDao() {
		super(JvmArgument.class);
	}

}