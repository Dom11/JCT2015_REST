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

import com.bluesky.rest.data.dao.JvmArgumentDao;
import com.bluesky.rest.data.pdo.JvmArgument;


/**
 * Resource Class.
 * Provides CRUD methods.
 * 
 * @author Dominik
 */
@Path("/jvm")
public class JvmArgumentResource extends AbstractResource {

	@Inject
	JvmArgumentDao jvmArgumentDao;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllJvmArguments() {

		List<JvmArgument> jvms = null;

		try {
			jvms = jvmArgumentDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<JvmArgument>>(jvms) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getJvmArgument(final @PathParam("id") int id) {

		JvmArgument jvmArgument = null;

		try {
			jvmArgument = jvmArgumentDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jvmArgument).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createJvmArgument(final JvmArgument jvmArgument) {

		JvmArgument jvmArgumentPersisted = null;

		try {
			jvmArgumentPersisted = jvmArgumentDao.save(jvmArgument);
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jvmArgumentPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateJvmArgument(final JvmArgument jvmArgument) {

		JvmArgument jvmArgumentPersisted = null;

		try {
			jvmArgumentPersisted = jvmArgumentDao.save(jvmArgument);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jvmArgumentPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteJvmArgument(final @PathParam("id") int id) {

		try {
			jvmArgumentDao.delete(id);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
	
}