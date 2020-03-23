package com.kingsroyale.listeners;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class Play {
    
    public static void parseUserInfo(String response) {
    	JSONObject obj = new JSONObject(response);
    	String ownerName = obj.getString("owner");

    	System.out.println(ownerName);
    }
	
	public static void getUserInfo(String username) throws Exception {
		URL obj = new URL("http://localhost:8001/api/kingdom/" + username);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			parseUserInfo(response.toString());
		} else {
			System.out.println(String.format("Error: %s", responseCode));
		}

	}
	
	
	
}
