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

import com.bluesky.rest.data.dao.JiraDao;
import com.bluesky.rest.data.pdo.Jira;


@Path("/jira")
public class JiraResource extends AbstractResource {

	@Inject
	JiraDao jiraDao;
	
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listAllJira() {
		
		List<Jira> jiras = null;

		try {
			jiras = jiraDao.findAll();

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(new GenericEntity<List<Jira>>(jiras) {
		}).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getJira(final @PathParam("id") int id) {

		Jira jira = null;

		try {
			jira = jiraDao.get(id);

		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jira).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createJira(final Jira jira) {

		Jira jiraPersisted = null;

		try {
			jiraPersisted = jiraDao.save(jira);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jiraPersisted).build();
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateJira(final Jira jira) {

		Jira jiraPersisted = null;

		try {
			jiraPersisted = jiraDao.save(jira);
			
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.ok(jiraPersisted).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteJira(final @PathParam("id") int id) {

		try {
			jiraDao.delete(id);
		} catch (Exception exception) {
			return handleException(exception);
		}
		return Response.status(Status.GONE).build();
	}
}