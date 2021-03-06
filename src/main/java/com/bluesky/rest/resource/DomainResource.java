package com.bluesky.rest.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bluesky.rest.data.dao.DomainDao;
import com.bluesky.rest.data.pdo.Domain;


/**
 * Resource Class.
 * Provides CRUD methods.
 * 
 * @author Dominik
 */
@Path("/domain")
public class DomainResource extends AbstractResource {

	@Inject
	DomainDao domainDao;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllDomains() {

		List<Domain> domains = null;

		try {
			domains = domainDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<Domain>>(domains) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getDomain(final @PathParam("id") int id) {

		Domain domain = null;

		try {
			domain = domainDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(domain).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDomain(final Domain domain) {

		Domain domainPersisted = null;

		try {
			domainPersisted = domainDao.save(domain);
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(domainPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDomain(final Domain domain) {

		Domain domainPersisted = null;

		try {
			domainPersisted = domainDao.save(domain);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(domainPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteDomain(final @PathParam("id") int id) {

		try {
			domainDao.delete(id);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
	
}