package com.mfatih.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mfatih.messenger.database.DatabaseClass;
import com.mfatih.messenger.model.Profile;

public class ProfileService 
{

	Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Mehmet", new Profile(1L, "firstProfile", "Mehmet", "KAN",new Date()));
		profiles.put("Fatih", new Profile(2L, "secondProfile", "Fatih", "KAN", new Date()));
		profiles.put("KAN", new Profile(3L, "thirdProfile", "Mehmet Fatih", "KAN", new Date()));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile p) {
		p.setId(profiles.size()+1);
		profiles.put(p.getProfileName(), p);    
		return p;
		
	}
	
	public Profile updateProfile(Profile p) {
		if(p.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(p.getProfileName(), p);
		return p;
	}
	
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
