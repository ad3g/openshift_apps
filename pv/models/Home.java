package com.pv.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Home {

@SerializedName("teamRank")
@Expose
private String teamRank;
@SerializedName("iconURL")
@Expose
private String iconURL;
@SerializedName("name")
@Expose
private String name;
@SerializedName("nameRaw")
@Expose
private String nameRaw;
@SerializedName("nameSeo")
@Expose
private String nameSeo;
@SerializedName("shortname")
@Expose
private String shortname;
@SerializedName("color")
@Expose
private String color;
@SerializedName("social")
@Expose
private Social social;
@SerializedName("description")
@Expose
private String description;
@SerializedName("currentScore")
@Expose
private String currentScore;
@SerializedName("scoreBreakdown")
@Expose
private List<String> scoreBreakdown = new ArrayList<String>();
@SerializedName("winner")
@Expose
private String winner;

/**
* 
* @return
* The teamRank
*/
public String getTeamRank() {
return teamRank;
}

/**
* 
* @param teamRank
* The teamRank
*/
public void setTeamRank(String teamRank) {
this.teamRank = teamRank;
}

/**
* 
* @return
* The iconURL
*/
public String getIconURL() {
return iconURL;
}

/**
* 
* @param iconURL
* The iconURL
*/
public void setIconURL(String iconURL) {
this.iconURL = iconURL;
}

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
public void setName(String name) {
this.name = name;
}

/**
* 
* @return
* The nameRaw
*/
public String getNameRaw() {
return nameRaw;
}

/**
* 
* @param nameRaw
* The nameRaw
*/
public void setNameRaw(String nameRaw) {
this.nameRaw = nameRaw;
}

/**
* 
* @return
* The nameSeo
*/
public String getNameSeo() {
return nameSeo;
}

/**
* 
* @param nameSeo
* The nameSeo
*/
public void setNameSeo(String nameSeo) {
this.nameSeo = nameSeo;
}

/**
* 
* @return
* The shortname
*/
public String getShortname() {
return shortname;
}

/**
* 
* @param shortname
* The shortname
*/
public void setShortname(String shortname) {
this.shortname = shortname;
}

/**
* 
* @return
* The color
*/
public String getColor() {
return color;
}

/**
* 
* @param color
* The color
*/
public void setColor(String color) {
this.color = color;
}

/**
* 
* @return
* The social
*/
public Social getSocial() {
return social;
}

/**
* 
* @param social
* The social
*/
public void setSocial(Social social) {
this.social = social;
}

/**
* 
* @return
* The description
*/
public String getDescription() {
return description;
}

/**
* 
* @param description
* The description
*/
public void setDescription(String description) {
this.description = description;
}

/**
* 
* @return
* The currentScore
*/
public String getCurrentScore() {
return currentScore;
}

/**
* 
* @param currentScore
* The currentScore
*/
public void setCurrentScore(String currentScore) {
this.currentScore = currentScore;
}

/**
* 
* @return
* The scoreBreakdown
*/
public List<String> getScoreBreakdown() {
return scoreBreakdown;
}

/**
* 
* @param scoreBreakdown
* The scoreBreakdown
*/
public void setScoreBreakdown(List<String> scoreBreakdown) {
this.scoreBreakdown = scoreBreakdown;
}

/**
* 
* @return
* The winner
*/
public String getWinner() {
return winner;
}

/**
* 
* @param winner
* The winner
*/
public void setWinner(String winner) {
this.winner = winner;
}

}
