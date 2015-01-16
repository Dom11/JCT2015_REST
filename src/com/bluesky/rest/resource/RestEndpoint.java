package com.bluesky.rest.resource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * End point from a client perspective
 * Root of the server side tree
 * 
 * @author Dominik
 *
 */

@ApplicationPath("/rest")
public class RestEndpoint extends Application {

	public RestEndpoint() {

	}
}