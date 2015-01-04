package com.bluesky.rest.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import com.bluesky.rest.client.ProfileClient;
import com.bluesky.rest.model.Profile;

@Named
@SessionScoped
public class ProfileController extends AbstractController implements
		Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProfileClient profileClient;

	private List<Profile> profiles;

	private Profile selectedProfile;

	// --- Constructors

	@PostConstruct
	private void populateApps() throws IOException {

		profiles = new ArrayList<Profile>();

		try {
			profiles = profileClient.listProfiles();

		} catch (Exception e) {
			submitMessage(FacesMessage.SEVERITY_ERROR,
					"Failure : Exception occured, please check logfile...", e,
					false);
		}
		submitMessage(FacesMessage.SEVERITY_INFO, profiles.size()
				+ " record(s) retrieved...", true);
	}

	// Accessors

	public Profile getSelectedProfile() {
		if (this.selectedProfile == null) {
			this.selectedProfile = new Profile();
		}
		return this.selectedProfile;
	}

	public void setSelectedProfile(Profile selectedProfile) {
		this.selectedProfile = selectedProfile;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	// Action methods

	public void refreshProfiles() {
		profiles = new ArrayList<Profile>();

		try {
			profiles = profileClient.listProfiles();

		} catch (Exception e) {
			submitMessage(FacesMessage.SEVERITY_ERROR,
					"Failure : Exception occured, please check logfile...", e,
					false);
		}
		submitMessage(FacesMessage.SEVERITY_INFO, profiles.size()
				+ " record(s) retrieved...", true);

	}

}
