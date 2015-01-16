package com.bluesky.rest.cdi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDI producers and disposer go here
 * 
 * @author u24279
 * @version $Revision$, $Date$
 */
public class Resources {

	@Produces
	Logger createLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember()
				.getDeclaringClass().getName());
	}

	@Produces
	@AuditLogger
	public Logger getAuditLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger("audit");
	}

}
