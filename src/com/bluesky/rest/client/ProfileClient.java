package com.bluesky.rest.client;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bluesky.rest.cdi.interceptors.Audited;
import com.bluesky.rest.model.Profile;


/**
 * read
 * http://howtodoinjava.com/2013/08/03/jax-rs-2-0-resteasy-3-0-2-final-client-api-example/
 * 
 * @author u24279, modified by drey
 */
public class ProfileClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String REST_SERVICE_URL = "http://localhost:8080/RestService/rest/profiles";

	@Inject
	Client client;

	@Audited
	public List<Profile> listProfiles() {

		Response response = client.target(REST_SERVICE_URL).path("/list")
				.request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR
				.getStatusCode()) {
			throw new IllegalStateException(response.getStatusInfo()
					.getReasonPhrase());
		} else {
			return response.readEntity(new GenericType<List<Profile>>() {
			});
		}
	}

	public Profile getProfile(int id) {

		Response response = client.target(REST_SERVICE_URL).path("/{id}")
				.queryParam("id", id).request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR
				.getStatusCode()) {
			throw new IllegalStateException(response.getStatusInfo()
					.getReasonPhrase());
		} else {
			return response.readEntity(Profile.class);
		}
	}

	public Profile createProfile(Profile profile) {

		Response response = client.target(REST_SERVICE_URL)
				.request(MediaType.APPLICATION_JSON).post(Entity.json(profile));

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR
				.getStatusCode()) {
			throw new IllegalStateException(response.getStatusInfo()
					.getReasonPhrase());
		} else {
			return response.readEntity(Profile.class);
		}
	}

	public Profile updateProfile(Profile profile) {

		Response response = client.target(REST_SERVICE_URL)
				.request(MediaType.APPLICATION_JSON).put(Entity.json(profile));

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR
				.getStatusCode()) {
			throw new IllegalStateException(response.getStatusInfo()
					.getReasonPhrase());
		} else {
			return response.readEntity(Profile.class);
		}
	}

	public Profile deleteProfile(int id) {

		Response response = client.target(REST_SERVICE_URL).path("/{id}")
				.queryParam("id", id).request(MediaType.APPLICATION_JSON)
				.delete();

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR
				.getStatusCode()) {
			throw new IllegalStateException(response.getStatusInfo()
					.getReasonPhrase());
		} else {
			return response.readEntity(Profile.class);
		}
	}
}
