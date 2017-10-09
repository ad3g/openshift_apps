package com.pv.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pv.Game;

@Generated("org.jsonschema2pojo")
public class Example {

@SerializedName("scoreboard")
@Expose
private List<Scoreboard> scoreboard = new ArrayList<Scoreboard>();
private Game game = new Game();

/**
* 
* @return
* The scoreboard
*/
public List<Scoreboard> getScoreboard() {
return scoreboard;
}

/**
* 
* @param scoreboard
* The scoreboard
*/
public void setScoreboard(List<Scoreboard> scoreboard) {
this.scoreboard = scoreboard;
}

public Game getGame() {
	return game;
}

public void setGame(Game game) {
	this.game = game;
}

}
