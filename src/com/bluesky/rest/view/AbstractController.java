package com.bluesky.rest.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class AbstractController {

	/**
	 * convenience method for JSF message generation.
	 * 
	 * @param severity
	 * @param summary
	 * @param details
	 */
	protected void submitMessage(Severity severity, String summary,
			Exception exception, boolean single) {

		String details = null;

		if (single) {
			clearMessages();
		}

		if (severity.equals(FacesMessage.SEVERITY_ERROR)) {

			StringWriter sw = new StringWriter();
			exception.printStackTrace(new PrintWriter(sw));
			details = sw.toString();

		} else {
			details = exception.getMessage();
		}

		FacesMessage fm = new FacesMessage(severity, summary, details);
		FacesContext.getCurrentInstance().addMessage("Message", fm);
	}

	/**
	 * convenience method for JSF message generation.
	 * 
	 * @param severity
	 * @param summary
	 */
	protected void submitMessage(Severity severity, String summary,
			boolean single) {

		if (single) {
			clearMessages();
		}

		FacesMessage fm = new FacesMessage(severity, summary, "");
		FacesContext.getCurrentInstance().addMessage("Message", fm);
	}

	/**
	 * flush all messages from context.
	 * 
	 */
	protected void clearMessages() {
		Iterator<FacesMessage> msgIterator = FacesContext.getCurrentInstance()
				.getMessages();
		while (msgIterator.hasNext()) {
			msgIterator.next();
			msgIterator.remove();
		}
	}

}
