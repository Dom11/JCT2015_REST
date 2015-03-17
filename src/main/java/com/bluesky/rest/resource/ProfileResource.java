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

import com.bluesky.rest.data.dao.ProfileDao;
import com.bluesky.rest.data.pdo.Profile;


@Path("/profile")
public class ProfileResource extends AbstractResource {

	@Inject
	ProfileDao profileDao;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllProfiles() {

		List<Profile> profiles = null;

		try {
			profiles = profileDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<Profile>>(profiles) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getProfile(final @PathParam("id") int id) {

		Profile profile = null;

		try {
			profile = profileDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profile).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfile(final Profile profile) {

		Profile profilePersisted = null;

		try {
			profilePersisted = profileDao.save(profile);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profilePersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfile(final Profile profile) {

		Profile profilePersisted = null;

		try {
			profilePersisted = profileDao.save(profile);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(profilePersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteProfile(final @PathParam("id") int id) {

		try {
			profileDao.delete(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
}
