package com.pv.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Accounts_ {

@SerializedName("ncaa")
@Expose
private String ncaa;
@SerializedName("athleticDept")
@Expose
private String athleticDept;
@SerializedName("sport")
@Expose
private String sport;
@SerializedName("conference")
@Expose
private String conference;

/**
* 
* @return
* The ncaa
*/
public String getNcaa() {
return ncaa;
}

/**
* 
* @param ncaa
* The ncaa
*/
public void setNcaa(String ncaa) {
this.ncaa = ncaa;
}

/**
* 
* @return
* The athleticDept
*/
public String getAthleticDept() {
return athleticDept;
}

/**
* 
* @param athleticDept
* The athleticDept
*/
public void setAthleticDept(String athleticDept) {
this.athleticDept = athleticDept;
}

/**
* 
* @return
* The sport
*/
public String getSport() {
return sport;
}

/**
* 
* @param sport
* The sport
*/
public void setSport(String sport) {
this.sport = sport;
}

/**
* 
* @return
* The conference
*/
public String getConference() {
return conference;
}

/**
* 
* @param conference
* The conference
*/
public void setConference(String conference) {
this.conference = conference;
}

}
