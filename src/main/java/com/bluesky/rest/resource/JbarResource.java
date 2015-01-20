package com.bluesky.rest.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bluesky.rest.data.dao.JbarDao;
import com.bluesky.rest.data.pdo.Jbar;


@Path("/jbar")
public class JbarResource {

	@Inject
	JbarDao jbarDao;
	
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllJbar() {
		
		List<Jbar> jbars = null;

		try {
			jbars = jbarDao.findAll();

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(new GenericEntity<List<Jbar>>(jbars) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getJbar(final @PathParam("id") int id) {

		Jbar jbar = null;

		try {
			jbar = jbarDao.get(id);

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.ok(jbar).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createJbar(final Jbar jbar) {

		Jbar jbarPersisted = null;

		try {
			jbarPersisted = jbarDao.save(jbar);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(jbarPersisted).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateJbar(final Jbar jbar) {

		Jbar jbarPersisted = null;

		try {
			jbarPersisted = jbarDao.save(jbar);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(jbarPersisted).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteJbar(final @PathParam("id") int id) {

		try {
			jbarDao.delete(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return Response.status(Status.GONE).build();

	}

}