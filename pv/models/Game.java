package com.pv.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Game {

@SerializedName("id")
@Expose
private String id;
@SerializedName("conference")
@Expose
private String conference;
@SerializedName("gameState")
@Expose
private String gameState;
@SerializedName("startDate")
@Expose
private String startDate;
@SerializedName("startDateDisplay")
@Expose
private String startDateDisplay;
@SerializedName("startTime")
@Expose
private String startTime;
@SerializedName("startTimeEpoch")
@Expose
private String startTimeEpoch;
@SerializedName("currentPeriod")
@Expose
private String currentPeriod;
@SerializedName("finalMessage")
@Expose
private String finalMessage;
@SerializedName("gameStatus")
@Expose
private String gameStatus;
@SerializedName("periodStatus")
@Expose
private String periodStatus;
@SerializedName("downToGo")
@Expose
private String downToGo;
@SerializedName("timeclock")
@Expose
private String timeclock;
@SerializedName("network_logo")
@Expose
private String networkLogo;
@SerializedName("location")
@Expose
private String location;
@SerializedName("contestName")
@Expose
private String contestName;
@SerializedName("url")
@Expose
private String url;
@SerializedName("highlightsUrl")
@Expose
private String highlightsUrl;
@SerializedName("liveAudioUrl")
@Expose
private String liveAudioUrl;
@SerializedName("gameCenterUrl")
@Expose
private String gameCenterUrl;
@SerializedName("champInfo")
@Expose
private ChampInfo champInfo;
@SerializedName("videos")
@Expose
private List<Object> videos = new ArrayList<Object>();
@SerializedName("scoreBreakdown")
@Expose
private List<String> scoreBreakdown = new ArrayList<String>();
@SerializedName("home")
@Expose
private Home home;
@SerializedName("away")
@Expose
private Away away;
@SerializedName("tabs")
@Expose
private String tabs;
@SerializedName("tabsArray")
@Expose
private List<List<TabsArray>> tabsArray = new ArrayList<List<TabsArray>>();
@SerializedName("status")
@Expose
private Status status;
@SerializedName("alerts")
@Expose
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
public String getNetworkLogo() {
return networkLogo;
}

/**
* 
* @param networkLogo
* The network_logo
*/
public void setNetworkLogo(String networkLogo) {
this.networkLogo = networkLogo;
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
return url;
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
public List<Object> getVideos() {
return videos;
}

/**
* 
* @param videos
* The videos
*/
public void setVideos(List<Object> videos) {
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

}
