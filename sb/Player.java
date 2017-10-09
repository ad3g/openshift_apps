package com.sb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class Player {

	private String PlayerId = "0";
	private String PlayerName = "";
	private int PlayerAmt = 0;
	private int row = 0;
	private int col = 0;
	private int[][] cell = null;
	
	public void loadCellsFromString() throws NamingException{
		System.out.println("Player, loadCellsFromString");
		
		Game g = new Game();
		g.getGame();
		ArrayList<String> PNUM = new ArrayList<String>(Arrays.asList(g.getPlayerNumbers().split(",")));
		
		cell = new int[10][10];
		int iRow = 0;
		int iCol = 0;
		int iCnt = 0;
		for(int i = 0; i < PNUM.size(); i++){
//			System.out.println("Value:" + PNUM.get(i).toString().trim() + " row: " + iRow + " col: " + iCol);
			cell[iRow][iCol] = Integer.parseInt(PNUM.get(i).trim());
			iCol++;
			iCnt++;
			if (iCnt > 9){iRow++;iCol = 0;iCnt = 0;}
		}
//		for(int i = 0; i < 10; i++){
//		    for(int j = 0; j < 10; j++) {
//		        int x = cell[i][j];
//		    	if (j<10) {
//		            System.out.print("   " + x + "   ");
//		        } else {
//		            System.out.print(x + "   ");
//		        }
//		    }
//		}
//		System.out.println("");
//		System.out.println("cell value[0][4]: " + cell[0][4]);
//		System.out.println("cell value[1][1]: " + cell[1][1]);
		System.out.println("Player, loadCellsFromString, done");
	}
	
	public int getCellValue(int iR, int iC){
		System.out.println("Player, getCellValue row: " + iR + " col: " + iC);
		int iRtn = 0;
		
		iRtn = cell[iR][iC];
		
		System.out.println("Player, getCellValue, done");
		return iRtn;
	}
	
	public String getPlayerId() {
		return PlayerId;
	}
	public void setPlayerId(String playerId) {
		PlayerId = playerId;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public int getPlayerAmt() {
		return PlayerAmt;
	}
	public void setPlayerAmt(int playerAmt) {
		PlayerAmt = playerAmt;
	}
	public ArrayList<Player> getPlayerList() throws NamingException {
		System.out.println("Scores, getPlayerList");

		ArrayList<Player> lPlayer = new ArrayList<Player>();
		String sql = "SELECT PLAYERID, PLAYER_DISP_NAME, PLAYER_AMT FROM apps.`SB_PLAYER`";

		//MVDBHelper dbh = new MVDBHelper();
//		Connection conn = null;
		//conn = dbh.getLocalConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Player p = new Player();
				p.setPlayerId(rs.getString(1));
				p.setPlayerName(rs.getString(2));
				p.setPlayerAmt(rs.getInt(3));
				lPlayer.add(p);
			}

			pstmt.close();
			//conn.close();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally 
		{
//			try {
//				if (conn != null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				e.printStackTrace();
//			}
		}	
		return lPlayer;
	}	
}
