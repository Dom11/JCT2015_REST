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

import com.bluesky.rest.data.dao.ProfileViewDao;
import com.bluesky.rest.data.pdo.ProfileView;


/**
 * Resource Class.
 * Provides CRUD methods.
 * 
 * @author Dominik
 */
@Path("/profileView")
public class ProfileViewResource extends AbstractResource {

	@Inject
	ProfileViewDao profileViewDao;

		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllProfileviews() {
		
		List<ProfileView> profileViews = null;

		try {
			profileViews = profileViewDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<ProfileView>>(profileViews) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getProfileview(final @PathParam("id") int id) {

		ProfileView profileView = null;

		try {
			profileView = profileViewDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profileView).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfileview(final ProfileView profileview) {

		ProfileView profileviewPersisted = null;

		try {
			profileviewPersisted = profileViewDao.save(profileview);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profileviewPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfileview(final ProfileView profileview) {

		ProfileView profileviewPersisted = null;

		try {
			profileviewPersisted = profileViewDao.save(profileview);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profileviewPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteProfileview(final @PathParam("id") int id) {

		try {
			profileViewDao.delete(id);
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
	
}