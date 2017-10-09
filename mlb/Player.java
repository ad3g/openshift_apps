package com.mlb;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Player {

@JsonProperty("std_hr")
private String stdHr;
@JsonProperty("hr")
private String hr;
@JsonProperty("id")
private String id;
@JsonProperty("last")
private String last;
@JsonProperty("team_code")
private String teamCode;
@JsonProperty("inning")
private String inning;
@JsonProperty("runners")
private String runners;
@JsonProperty("number")
private String number;
@JsonProperty("name_display_roster")
private String nameDisplayRoster;
@JsonProperty("first")
private String first;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The stdHr
*/
@JsonProperty("std_hr")
public String getStdHr() {
return stdHr;
}

/**
* 
* @param stdHr
* The std_hr
*/
@JsonProperty("std_hr")
public void setStdHr(String stdHr) {
this.stdHr = stdHr;
}

/**
* 
* @return
* The hr
*/
@JsonProperty("hr")
public String getHr() {
return hr;
}

/**
* 
* @param hr
* The hr
*/
@JsonProperty("hr")
public void setHr(String hr) {
this.hr = hr;
}

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The last
*/
@JsonProperty("last")
public String getLast() {
return last;
}

/**
* 
* @param last
* The last
*/
@JsonProperty("last")
public void setLast(String last) {
this.last = last;
}

/**
* 
* @return
* The teamCode
*/
@JsonProperty("team_code")
public String getTeamCode() {
return teamCode;
}

/**
* 
* @param teamCode
* The team_code
*/
@JsonProperty("team_code")
public void setTeamCode(String teamCode) {
this.teamCode = teamCode;
}

/**
* 
* @return
* The inning
*/
@JsonProperty("inning")
public String getInning() {
return inning;
}

/**
* 
* @param inning
* The inning
*/
@JsonProperty("inning")
public void setInning(String inning) {
this.inning = inning;
}

/**
* 
* @return
* The runners
*/
@JsonProperty("runners")
public String getRunners() {
return runners;
}

/**
* 
* @param runners
* The runners
*/
@JsonProperty("runners")
public void setRunners(String runners) {
this.runners = runners;
}

/**
* 
* @return
* The number
*/
@JsonProperty("number")
public String getNumber() {
return number;
}

/**
* 
* @param number
* The number
*/
@JsonProperty("number")
public void setNumber(String number) {
this.number = number;
}

/**
* 
* @return
* The nameDisplayRoster
*/
@JsonProperty("name_display_roster")
public String getNameDisplayRoster() {
return nameDisplayRoster;
}

/**
* 
* @param nameDisplayRoster
* The name_display_roster
*/
@JsonProperty("name_display_roster")
public void setNameDisplayRoster(String nameDisplayRoster) {
this.nameDisplayRoster = nameDisplayRoster;
}

/**
* 
* @return
* The first
*/
@JsonProperty("first")
public String getFirst() {
return first;
}

/**
* 
* @param first
* The first
*/
@JsonProperty("first")
public void setFirst(String first) {
this.first = first;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
