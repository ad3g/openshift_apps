package com.pv;

import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class NCAA_Football {

	private String defaultJson = "{\"scoreboard\": [{\"day\":\"No Game Data Available\",\"games\":[]}]}";
	
	public NCAA_Football_JsonClasses getJSONObject(String dt) {

		JSONObject jsonObject = new JSONObject();

		String genreJson = null;
		try 
		{
			genreJson = IOUtils.toString(new URL("http://data.ncaa.com/jsonp/scoreboard/basketball-men/d1/" + dt + "/scoreboard.html"));
			genreJson = genreJson.substring(16);
			genreJson = genreJson.substring(0, genreJson.length() - 2);
		}
		catch (Exception e) 
		{
			genreJson = defaultJson;
		}

		Gson gson = new Gson();
		NCAA_Football_JsonClasses bb = gson.fromJson(genreJson, NCAA_Football_JsonClasses.class);
//		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
//		mapper.enable(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//		mapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//		//mapper.enable(DeserializationConfig.Feature.WRAP_EXCEPTIONS);
//		//mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//		NCAA_Basketball_JsonClasses bb = null;
//		try {
//			bb = mapper.readValue(genreJson, NCAA_Basketball_JsonClasses.class);
//
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		return bb;
	}
}
