package com.mm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Game {

private String id;
private String tournament_id;
private String season_year;
private String bracket;
private String bracketId;
private String bracketRound;
private String bracketRegion;
private String venue;
private String venueCity;
private String venueState;
private String venueCityState;
private String network;
private String isLiveEnabled;
private String conference;
private String gameState;
private String startDate;
private String startDateDisplay;
private String startTime;
private String startTimeEpoch;
private String currentPeriod;
private String finalMessage;
private String gameStatus;
private String periodStatus;
private String downToGo;
private String timeclock;
private String network_logo;
private String location;
private String contestName;
private String url;
private String highlightsUrl;
private String liveAudioUrl;
private String gameCenterUrl;
private ChampInfo champInfo;
private List<Video> videos = new ArrayList<Video>();
private List<String> scoreBreakdown = new ArrayList<String>();
private Home home;
private Away away;
private String tabs;
private List<List<TabsArray>> tabsArray = new ArrayList<List<TabsArray>>();
private Status status;
private Alerts alerts;

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
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

/**
* 
* @return
* The gameState
*/
public String getGameState() {
return gameState;
}

/**
* 
* @param gameState
* The gameState
*/
public void setGameState(String gameState) {
this.gameState = gameState;
}

/**
* 
* @return
* The startDate
*/
public String getStartDate() {
return startDate;
}

/**
* 
* @param startDate
* The startDate
*/
public void setStartDate(String startDate) {
this.startDate = startDate;
}

/**
* 
* @return
* The startDateDisplay
*/
public String getStartDateDisplay() {
return startDateDisplay;
}

/**
* 
* @param startDateDisplay
* The startDateDisplay
*/
public void setStartDateDisplay(String startDateDisplay) {
this.startDateDisplay = startDateDisplay;
}

/**
* 
* @return
* The startTime
*/
public String getStartTime() {
return startTime;
}

/**
* 
* @param startTime
* The startTime
*/
public void setStartTime(String startTime) {
this.startTime = startTime;
}

/**
* 
* @return
* The startTimeEpoch
*/
public String getStartTimeEpoch() {
return startTimeEpoch;
}

/**
* 
* @param startTimeEpoch
* The startTimeEpoch
*/
public void setStartTimeEpoch(String startTimeEpoch) {
this.startTimeEpoch = startTimeEpoch;
}

/**
* 
* @return
* The currentPeriod
*/
public String getCurrentPeriod() {
return currentPeriod;
}

/**
* 
* @param currentPeriod
* The currentPeriod
*/
public void setCurrentPeriod(String currentPeriod) {
this.currentPeriod = currentPeriod;
}

/**
* 
* @return
* The finalMessage
*/
public String getFinalMessage() {
return finalMessage;
}

/**
* 
* @param finalMessage
* The finalMessage
*/
public void setFinalMessage(String finalMessage) {
this.finalMessage = finalMessage;
}

/**
* 
* @return
* The gameStatus
*/
public String getGameStatus() {
return gameStatus;
}

/**
* 
* @param gameStatus
* The gameStatus
*/
public void setGameStatus(String gameStatus) {
this.gameStatus = gameStatus;
}

/**
* 
* @return
* The periodStatus
*/
public String getPeriodStatus() {
return periodStatus;
}

/**
* 
* @param periodStatus
* The periodStatus
*/
public void setPeriodStatus(String periodStatus) {
this.periodStatus = periodStatus;
}

/**
* 
* @return
* The downToGo
*/
public String getDownToGo() {
return downToGo;
}

/**
* 
* @param downToGo
* The downToGo
*/
public void setDownToGo(String downToGo) {
this.downToGo = downToGo;
}

/**
* 
* @return
* The timeclock
*/
public String getTimeclock() {
return timeclock;
}

/**
* 
* @param timeclock
* The timeclock
*/
public void setTimeclock(String timeclock) {
this.timeclock = timeclock;
}

/**
* 
* @return
* The networkLogo
*/
public String getNetwork_logo() {
return network_logo;
}

/**
* 
* @param networkLogo
* The network_logo
*/
public void setNetwork_logo(String network_logo) {
this.network_logo = network_logo;
}

/**
* 
* @return
* The location
*/
public String getLocation() {
return location;
}

/**
* 
* @param location
* The location
*/
public void setLocation(String location) {
this.location = location;
}

/**
* 
* @return
* The contestName
*/
public String getContestName() {
return contestName;
}

/**
* 
* @param contestName
* The contestName
*/
public void setContestName(String contestName) {
this.contestName = contestName;
}

/**
* 
* @return
* The url
*/
public String getUrl() {
return "http:\\\\www.ncaa.com" + url;
}

/**
* 
* @param url
* The url
*/
public void setUrl(String url) {
this.url = url;
}

/**
* 
* @return
* The highlightsUrl
*/
public String getHighlightsUrl() {
return highlightsUrl;
}

/**
* 
* @param highlightsUrl
* The highlightsUrl
*/
public void setHighlightsUrl(String highlightsUrl) {
this.highlightsUrl = highlightsUrl;
}

/**
* 
* @return
* The liveAudioUrl
*/
public String getLiveAudioUrl() {
return liveAudioUrl;
}

/**
* 
* @param liveAudioUrl
* The liveAudioUrl
*/
public void setLiveAudioUrl(String liveAudioUrl) {
this.liveAudioUrl = liveAudioUrl;
}

/**
* 
* @return
* The gameCenterUrl
*/
public String getGameCenterUrl() {
return gameCenterUrl;
}

/**
* 
* @param gameCenterUrl
* The gameCenterUrl
*/
public void setGameCenterUrl(String gameCenterUrl) {
this.gameCenterUrl = gameCenterUrl;
}

/**
* 
* @return
* The champInfo
*/
public ChampInfo getChampInfo() {
return champInfo;
}

/**
* 
* @param champInfo
* The champInfo
*/
public void setChampInfo(ChampInfo champInfo) {
this.champInfo = champInfo;
}

/**
* 
* @return
* The videos
*/
public List<Video> getVideos() {
return videos;
}

/**
* 
* @param videos
* The videos
*/
public void setVideos(List<Video> videos) {
this.videos = videos;
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
* The home
*/
public Home getHome() {
return home;
}

/**
* 
* @param home
* The home
*/
public void setHome(Home home) {
this.home = home;
}

/**
* 
* @return
* The away
*/
public Away getAway() {
return away;
}

/**
* 
* @param away
* The away
*/
public void setAway(Away away) {
this.away = away;
}

/**
* 
* @return
* The tabs
*/
public String getTabs() {
return tabs;
}

/**
* 
* @param tabs
* The tabs
*/
public void setTabs(String tabs) {
this.tabs = tabs;
}

/**
* 
* @return
* The tabsArray
*/
public List<List<TabsArray>> getTabsArray() {
return tabsArray;
}

/**
* 
* @param tabsArray
* The tabsArray
*/
public void setTabsArray(List<List<TabsArray>> tabsArray) {
this.tabsArray = tabsArray;
}

/**
* 
* @return
* The status
*/
public Status getStatus() {
return status;
}

/**
* 
* @param status
* The status
*/
public void setStatus(Status status) {
this.status = status;
}

/**
* 
* @return
* The alerts
*/
public Alerts getAlerts() {
return alerts;
}

/**
* 
* @param alerts
* The alerts
*/
public void setAlerts(Alerts alerts) {
this.alerts = alerts;
}

public String getTournament_id() {
	return tournament_id;
}

public void setTournament_id(String tournament_id) {
	this.tournament_id = tournament_id;
}

public String getSeason_year() {
	return season_year;
}

public void setSeason_year(String season_year) {
	this.season_year = season_year;
}

public String getBracket() {
	return bracket;
}

public void setBracket(String bracket) {
	this.bracket = bracket;
}

public String getBracketId() {
	return bracketId;
}

public void setBracketId(String bracketId) {
	this.bracketId = bracketId;
}

public String getBracketRound() {
	return bracketRound;
}

public void setBracketRound(String bracketRound) {
	this.bracketRound = bracketRound;
}

public String getBracketRegion() {
	return bracketRegion;
}

public void setBracketRegion(String bracketRegion) {
	this.bracketRegion = bracketRegion;
}

public String getVenue() {
	return venue;
}

public void setVenue(String venue) {
	this.venue = venue;
}

public String getVenueCity() {
	return venueCity;
}

public void setVenueCity(String venueCity) {
	this.venueCity = venueCity;
}

public String getVenueState() {
	return venueState;
}

public void setVenueState(String venueState) {
	this.venueState = venueState;
}

public String getVenueCityState() {
	return venueCityState;
}

public void setVenueCityState(String venueCityState) {
	this.venueCityState = venueCityState;
}

public String getNetwork() {
	return network;
}

public void setNetwork(String network) {
	this.network = network;
}

public String getIsLiveEnabled() {
	return isLiveEnabled;
}

public void setIsLiveEnabled(String isLiveEnabled) {
	this.isLiveEnabled = isLiveEnabled;
}



}

