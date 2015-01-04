package com.bluesky.rest.cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluesky.rest.util.GsonMessageBodyHandler;

/**
 * TODO CDI producers and disposer go here
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

	@Produces
	public Client createRestStub() {

		return ClientBuilder.newClient().register(GsonMessageBodyHandler.class);

	}

	public void disposeRestStub(@Disposes Client client) {
		if (client != null) {
			try {
				client.close();
			} catch (IllegalStateException e) {
				throw new RuntimeException("Error closing REST client.", e);
			}

		}

	}

}
