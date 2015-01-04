package com.bluesky.rest.cdi.interceptors;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.TransactionManager;

import org.slf4j.Logger;
import org.slf4j.MDC;

import com.bluesky.rest.cdi.AuditLogger;

/**
 * 
 * Intercepting business calls and logging contextual information , like active
 * JTA transaction ID, business method name and actual user. Uses diagnostic
 * context to flushing information to underlying logging framework, clears the
 * diagnostic map after completion.
 * 
 * see http://city81.blogspot.ch/2011/01/extending-bean-functionality-using.html
 * and https://developer.jboss.org/wiki/LoggingContextualInformation
 * 
 * @author u24279
 * @version $Revision$, $Date$
 */
@Interceptor
@Audited
public class AuditInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// expose diagnostic context to log appender message formats like this one:
	// "%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c] (%t) REQ-TRN=%X{REQ_TRX_ID} METHOD=%X{REQ_METHOD} USER=%X{USER_ID} %s%E%n"
	public static final String MDC_METHOD = "REQ_METHOD";
	public static final String MDC_TRANSACTION = "REQ_TRX_ID";
	public static final String MDC_USER = "USER_ID";

	@Inject
	@AuditLogger
	private Logger logger;

	@Inject
	Principal principal;

	@Resource(mappedName = "java:/TransactionManager")
	private TransactionManager tm;

	@AroundInvoke
	public Object audit(InvocationContext ctx) throws Exception {

		MDC.put(MDC_USER, principal.getName());
		MDC.put(MDC_METHOD, ctx.getMethod().getName());
		// see https://developer.jboss.org/wiki/LoggingContextualInformation

		if (tm.getTransaction() != null) {
			MDC.put(MDC_TRANSACTION, tm.getTransaction().toString());
		} else {
			MDC.put(MDC_TRANSACTION, "none");
		}

		logger.info("logged by {}", this.getClass().getSimpleName());

		MDC.remove(MDC_TRANSACTION);
		MDC.remove(MDC_METHOD);
		MDC.remove(MDC_USER);

		return ctx.proceed();

	}

}