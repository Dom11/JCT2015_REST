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

import com.bluesky.rest.data.dao.PrefixDao;
import com.bluesky.rest.data.pdo.Prefix;


/**
 * Resource Class.
 * Provides CRUD methods.
 * 
 * @author Dominik
 */
@Path("/prefix")
public class PrefixResource extends AbstractResource {

	@Inject
	PrefixDao prefixDao;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllPrefixes() {

		List<Prefix> prefixes = null;

		try {
			prefixes = prefixDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<Prefix>>(prefixes) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getPrefix(final @PathParam("id") int id) {

		Prefix prefix = null;

		try {
			prefix = prefixDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(prefix).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPrefix(final Prefix prefix) {

		Prefix prefixPersisted = null;

		try {
			prefixPersisted = prefixDao.save(prefix);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(prefixPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePrefix(final Prefix prefix) {

		Prefix prefixPersisted = null;

		try {
			prefixPersisted = prefixDao.save(prefix);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(prefixPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deletePrefix(final @PathParam("id") int id) {

		try {
			prefixDao.delete(id);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
	
}