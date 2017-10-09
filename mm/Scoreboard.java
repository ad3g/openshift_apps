package com.mm;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Scoreboard {

	private String day;
	private List<Game> games = new ArrayList<Game>();

	/**
	 * 
	 * @return
	 * The day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * 
	 * @param day
	 * The day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * 
	 * @return
	 * The games
	 */
	public List<Game> getGames() {
		return games;
	}

	/**
	 * 
	 * @param games
	 * The games
	 */
	public void setGames(List<Game> games) {
		this.games = games;
	}

}
