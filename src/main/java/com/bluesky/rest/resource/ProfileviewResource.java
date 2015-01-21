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

import com.bluesky.rest.data.dao.ProfileviewDao;
import com.bluesky.rest.data.pdo.Profileview;


@Path("/profileview")
public class ProfileviewResource {

	@Inject
	ProfileviewDao profileviewDao;

		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllProfileviews() {
		
		List<Profileview> profileviews = null;

		try {
			profileviews = profileviewDao.findAll();

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(new GenericEntity<List<Profileview>>(profileviews) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getProfileview(final @PathParam("id") int id) {

		Profileview profileview = null;

		try {
			profileview = profileviewDao.get(id);

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.ok(profileview).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfileview(final Profileview profileview) {

		Profileview profileviewPersisted = null;

		try {
			profileviewPersisted = profileviewDao.save(profileview);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(profileviewPersisted).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfileview(final Profileview profileview) {

		Profileview profileviewPersisted = null;

		try {
			profileviewPersisted = profileviewDao.save(profileview);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(profileviewPersisted).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteProfileview(final @PathParam("id") int id) {

		try {
			profileviewDao.delete(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return Response.status(Status.GONE).build();

	}

}