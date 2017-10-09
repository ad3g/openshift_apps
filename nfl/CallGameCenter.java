package com.nfl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CallGameCenter {

	public static String getUrlSource(String url) throws IOException {
		URL yahoo = new URL(url);
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = null;
		StringBuilder a = new StringBuilder();
		try 
		{
			in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				a.append(inputLine);
			}
			in.close();
		}
		catch (IOException ioe)
		{
			a.append("Not Found");
		}
		return a.toString();
	}
}
