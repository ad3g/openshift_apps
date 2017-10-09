package com.pv.models;

import com.pv.GameDAO;

public class PV_Main {

	public static void main(String[] args) throws Exception {
		GameDAO gDao = new GameDAO();
		//gDao.testUpdateScores("2015");
		gDao.testUpdateScores("2016");
		
		//
		//BuildGameInserts();
	}
//	public static void BuildGameInserts() throws Exception{
//		GameDAO gDao = new GameDAO();
//
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/15/scoreboard.html", "2015");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/16/scoreboard.html", "2015");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/17/scoreboard.html", "2015");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/18/scoreboard.html", "2015");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/19/scoreboard.html", "2015");
//		String isrtSql = "INSERT INTO `apps`.`PV_GAME` (`GID`,`YR`,`GNAME`,`T1_NAME`,`T2_NAME`,`LOC`,`DTE`,`TV`, `PAY_2`, `PAY_F`, `BRACKET_HTML`)VALUES(UUID(),'";
//		isrtSql += "2015" + "', '";
//		isrtSql += "FBS National Championship";
//		isrtSql += "', '";
//		isrtSql += "TBD";
//		isrtSql += "', '";
//		isrtSql += "TBD";
//		isrtSql += "', '";
//		isrtSql += "Location TBD";
//		isrtSql += "', '";
//		isrtSql += "Date TBD";
//		isrtSql += "', '";
//		isrtSql += "Network";
//		isrtSql += "', '";
//		isrtSql += "25', '50', 'Bracket Numbers Not Assigned');";
//		System.out.println(isrtSql);
//
//		
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/15/scoreboard.html", "2016");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/16/scoreboard.html", "2016");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/17/scoreboard.html", "2016");
//		gDao.buildGameInserts("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/18/scoreboard.html", "2016");
//		isrtSql = "INSERT INTO `apps`.`PV_GAME` (`GID`,`YR`,`GNAME`,`T1_NAME`,`T2_NAME`,`LOC`,`DTE`,`TV`, `PAY_2`, `PAY_F`, `BRACKET_HTML`)VALUES(UUID(),'";
//		isrtSql += "2016" + "', '";
//		isrtSql += "FBS National Championship";
//		isrtSql += "', '";
//		isrtSql += "TBD";
//		isrtSql += "', '";
//		isrtSql += "TBD";
//		isrtSql += "', '";
//		isrtSql += "Location TBD";
//		isrtSql += "', '";
//		isrtSql += "Date TBD";
//		isrtSql += "', '";
//		isrtSql += "Network";
//		isrtSql += "', '";
//		isrtSql += "25', '50', 'Bracket Numbers Not Assigned');";
//		System.out.println(isrtSql);
//	}
}
