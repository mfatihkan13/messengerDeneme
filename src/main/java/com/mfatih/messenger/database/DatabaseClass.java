package com.mfatih.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.mfatih.messenger.model.Message;
import com.mfatih.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messageMap = new HashMap<>();
	private static Map<String, Profile> profileMap = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messageMap;
	}

	public static Map<String, Profile> getProfiles() {
		return profileMap;
	}

}
