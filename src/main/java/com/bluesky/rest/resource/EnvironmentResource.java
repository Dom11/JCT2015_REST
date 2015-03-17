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

import com.bluesky.rest.data.dao.EnvironmentDao;
import com.bluesky.rest.data.pdo.Environment;


@Path("/environment")
public class EnvironmentResource extends AbstractResource {

	@Inject
	EnvironmentDao environmentDao;
	
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllEnvironments() {
		
		List<Environment> environments = null;

		try {
			environments = environmentDao.findAll();
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<Environment>>(environments) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getEnvironment(final @PathParam("id") int id) {

		Environment environment = null;

		try {
			environment = environmentDao.get(id);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(environment).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEnvironment(final Environment environment) {

		Environment environmentPersisted = null;

		try {
			environmentPersisted = environmentDao.save(environment);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(environmentPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEnvironment(final Environment environment) {

		Environment environmentPersisted = null;

		try {
			environmentPersisted = environmentDao.save(environment);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(environmentPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteEnvironment(final @PathParam("id") int id) {

		try {
			environmentDao.delete(id);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
}
