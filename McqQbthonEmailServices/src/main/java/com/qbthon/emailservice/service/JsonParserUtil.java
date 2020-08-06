package com.qbthon.emailservice.service;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParserUtil {
	
	public List<String> publishEmailidsFromEventObject(String eventobject) {
		
		ArrayList<String> emails = new ArrayList<>();
		JSONObject obj = new JSONObject(eventobject);
		JSONArray arr = obj.getJSONArray("L");
		for (int i = 0; i < arr.length(); i++) {
            String associate = arr.getJSONObject(i).getString("S");
           int index = associate.indexOf("email=");
           String substring = associate.substring(index+6);
           String ret = substring.substring(0,substring.indexOf(','));
           
           emails.add(ret);
        }
		
		return emails;
	}
	
	public String getJsonAttribute(String jsonobject,String getStringAttribute) {
		
		JSONObject obj = new JSONObject(jsonobject);
		return  obj.getString(getStringAttribute);
		
	}
	

}
