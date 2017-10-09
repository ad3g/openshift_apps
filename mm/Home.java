package com.mm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Home {

private String teamRank;
private String iconURL;
private String name;
private String nameRaw;
private String nameSeo;
private String shortname;
private String color;
private Social social;
private String description;
private String currentScore;
private List<String> scoreBreakdown = new ArrayList<String>();
private String winner;
private String teamSeed;
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
return "http://www.ncaa.com" + iconURL;
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

public String getTeamSeed() {
	return teamSeed;
}

public void setTeamSeed(String teamSeed) {
	this.teamSeed = teamSeed;
}


}
