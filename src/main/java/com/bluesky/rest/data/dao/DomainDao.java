package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Domain;


/**
 * Database Driver data access object (dao).
 * 
 * @author Dominik
 */
@Stateless
public class DomainDao extends GenericDao<Domain, Integer> {

	
	/**
	 * Constructor
	 */
	public DomainDao() {
		super(Domain.class);
	}

}