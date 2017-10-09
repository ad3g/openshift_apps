package com.pv.models;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NCAA_Football {

	public Example getJSONObject(String url) throws Exception {
		Example ex =  null;
		String genreJson = null;
		InputStream in = null;
		try {
			//in = new URL("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/18/scoreboard.html" ).openStream();
			in = new URL(url).openStream();
			String result = getStringFromInputStream(in);

			Gson gson = new Gson();
			genreJson = result;
			genreJson = genreJson.substring(16);
			genreJson = genreJson.substring(0, genreJson.length() - 2);


			ex = gson.fromJson(genreJson, Example.class);
		} finally {
		}	

//		String abc = ex.getScoreboard().get(0).getGames().get(0).getAway().getScoreBreakdown().get(0);
//		System.out.println("scoreboard0, game0, away, scorebreakdown0: " + abc);
		return ex;
	}
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}

