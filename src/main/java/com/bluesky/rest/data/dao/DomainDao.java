package com.bluesky.rest.data.dao;

import javax.ejb.Stateless;

import com.bluesky.rest.data.pdo.Domain;


/**
 * Database Driver data access object.
 * 
 */
@Stateless
public class DomainDao extends GenericDao<Domain, Integer> {

	// ---- Fields

	// ---- Constructors
	public DomainDao() {
		super(Domain.class);
	}
	
	// ---- Methods

}