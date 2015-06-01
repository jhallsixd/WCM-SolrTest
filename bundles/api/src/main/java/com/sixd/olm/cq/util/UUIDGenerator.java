package com.st.olm.cq.util;

import java.util.ArrayList;
import java.util.UUID;


public class UUIDGenerator {

	/**
	 * Generate UUID
	 * 
	 * @return random uuid
	 */
	public static final UUID generateUUID() {
		return UUID.randomUUID();
	}
	public static final String createPathFromUUID(String uuidToConvert){
		String uuidString = uuidToConvert.replace("-", "");
		ArrayList<String> s = new ArrayList<String>();
		while(uuidString.length() > 0){
			s.add(uuidString.substring(0,2));
			uuidString = uuidString.substring(2);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.size();i++){
			sb.append(s.get(i));
			sb.append("/");
		}
		return sb.toString();
	}
	public static final String createPathFromUUID(){
		return createPathFromUUID(UUID.randomUUID().toString());
	}
}