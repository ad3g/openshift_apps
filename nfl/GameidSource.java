package com.nfl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class GameidSource {

	public static ArrayList<String> getGameidsByWeek(String Wk) throws NamingException {
		ArrayList<String> lGameids = new ArrayList<String>();
		System.out.println("GameidSource, getGameidsByWeek");
		String sql = "select gameid from apps.nfl_gameid_src where Week = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, Wk);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				lGameids.add(rs.getString(1));
			}

			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
	    finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lGameids;
	}
}
