package com.bluesky.rest.resource;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;


/**
 * common behavior for every REST resource class.
 *
 * @author Rob
 * @version $Revision$, $Date$
 */
public abstract class AbstractResource {

	@Inject
	Logger logger;
	

	/**
	 * 
	 * Called whenever a EJB Exception is raised upon a EJB transaction boundary.
	 * The chained root cause exception will be translated to a proper HTTP status code and REST response object.
	 * 
	 * @param exception
	 * @return JAX-RS response containing HTTP code which reflects the original exception.
	 */
	protected Response handleException(Exception exception) {

		if (exception.getCause() instanceof NonUniqueResultException) {
			logger.warn(exception.getMessage());
			return Response.status(Status.BAD_REQUEST).entity("singleton query return multiple results").build();
		}
		if (exception.getCause() instanceof NoResultException) {
			logger.info(exception.getMessage());
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		}
		if (exception.getCause() instanceof LockTimeoutException) {
			logger.info(exception.getMessage());
			return Response.status(Status.NOT_FOUND).entity("record not found").build();
		}
		if (exception.getCause() instanceof OptimisticLockException) {
			logger.info(exception.getMessage());
			return Response.status(Status.CONFLICT).entity("record changed by another user").build();
		}
		if (exception.getCause() instanceof EntityExistsException) {
			logger.warn(exception.getMessage());
			return Response.status(Status.CONFLICT).entity("record already exists").build();
		}
		if (exception.getCause() instanceof QueryTimeoutException) {
			logger.warn(exception.getMessage());
			return Response.status(Status.BAD_REQUEST).entity("query timed out").build();
		}
		if (exception.getCause() instanceof ConstraintViolationException) {
			logger.error(exception.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(String.format("database integrity violation: %s",
							exception.getCause().getMessage())).build();
		}
		logger.error(exception.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception.getCause().getMessage()).build();
	}
}