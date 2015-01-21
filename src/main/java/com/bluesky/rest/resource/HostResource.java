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

import com.bluesky.rest.data.dao.HostDao;
import com.bluesky.rest.data.pdo.Host;


@Path("/host")
public class HostResource {

	@Inject
	HostDao hostDao;
	
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllHosts() {
		
		List<Host> hosts = null;

		try {
			hosts = hostDao.findAll();

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(new GenericEntity<List<Host>>(hosts) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getHost(final @PathParam("id") int id) {

		Host host = null;

		try {
			host = hostDao.get(id);

		} catch (NotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.ok(host).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHost(final Host host) {

		Host hostPersisted = null;

		try {
			hostPersisted = hostDao.save(host);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(hostPersisted).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateHost(final Host host) {

		Host hostPersisted = null;

		try {
			hostPersisted = hostDao.save(host);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(hostPersisted).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteHost(final @PathParam("id") int id) {

		try {
			hostDao.delete(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return Response.status(Status.GONE).build();

	}

}