package com.bluesky.rest.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.NotFoundException;

import com.bluesky.rest.model.Profile;

/**
 * 
 * read http://www.adam-bien.com/roller/abien/entry/
 * singleton_the_perfect_cache_facade
 * 
 * @author u24279
 * @version $Revision$, $Date$
 */
@Singleton
// @ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Repository {

	private ConcurrentHashMap<Integer, Profile> profiles = null;

	@PostConstruct
	public void initialize() {
		profiles = new ConcurrentHashMap<Integer, Profile>();

		profiles.put(1, new Profile(1, "name1", "description1", "SIT"));
		profiles.put(2, new Profile(2, "name2", "description2", "UAT"));
		profiles.put(3, new Profile(3, "name3", "description3", "PROD"));
		profiles.put(4, new Profile(4, "name4", "description4", "SIT"));
		profiles.put(5, new Profile(5, "name5", "description5", "PROD"));
		profiles.put(6, new Profile(6, "name6", "description6", "DEV"));
		profiles.put(7, new Profile(7, "name7", "description7", "AUT"));
	}

	public List<Profile> listProfiles() {

		if (profiles.size() != 0) {

			List<Profile> returnedProfiles = new ArrayList<Profile>();

			try {
				for (Profile profile : profiles.values()) {
					returnedProfiles.add(profile);
				}

				return returnedProfiles;

			} catch (Exception e) {

				System.out.println(e.getMessage());
				return null;
				// TODO: handle exception
			}

		} else {
			throw new NotFoundException("No profiles found!");

		}

	}

	public Profile getProfile(int id) {

		if (profiles.get(id) != null) {
			return profiles.get(id);

		} else {
			throw new NotFoundException(String.format(
					"Profile with id %s not found!", id));
		}

	}

	public Profile createProfile(Profile profile) {

		profiles.put(profile.getId(), profile);

		return profile;
	}

	public Profile updateProfile(Profile profile) {

		if (profiles.get(profile.getId()) != null) {
			profiles.remove(profile.getId());
			profiles.put(profile.getId(), profile);
			return profile;

		} else {
			throw new NotFoundException(String.format(
					"Profile with id %s not found!", profile.getId()));
		}

	}

	public void deleteProfile(int id) {

		if (profiles.get(id) != null) {
			profiles.remove(id);

		} else {
			throw new NotFoundException(String.format(
					"Profile with id %s not found!", id));
		}

	}

}
