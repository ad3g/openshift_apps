package com.mlb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class MLB_Bracket {
	private String bracket_id = "Not Available";
	private int bracket_seq = 0;
	private String p_name = "Not Available";
	private String p_team = "Not Available";
	private int R0 = 0;
	private int R1 = 0;
	private int R2 = 0;
	private int R3 = 0;
	private int R4 = 0;
	private int R5 = 0;
	private int R6 = 0;
	private int R7 = 0;
	private int R8 = 0;
	private int R9 = 0;
	private int R10 = 0;
	private int R11 = 0;
	private int R12 = 0;
	private int R13 = 0;
	private int Other = 0;
	private int Matches = 0;
	private int gp = 0;
	private String dt = "";

	public ArrayList<MLB_Bracket> loadHistoryList() throws NamingException {
		System.out.println("MLB_bracket, loadHistoryList, bracket_id: " + bracket_id);
		ArrayList<MLB_Bracket> lb = new ArrayList<MLB_Bracket>();
		
		String sql = "SELECT DATE(b.ISRT_TS) DT, b.ISRT_TS, b.BRACKET_ID FROM apps.mlb_bracket b where b.bracket_seq = 1 ORDER BY DT DESC";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MLB_Bracket b = new MLB_Bracket();
	
				//System.out.println("MLB_bracket, loadbracket within select, bracket_id: " + bracket_id);
				b.setDt(rs.getString(1));
				//b.setDt(rs.getString(2));
				b.setBracket_id(rs.getString(3));
				lb.add(b);
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
	
		return lb;
	}

	
	public ArrayList<MLB_Bracket> loadbrackets() throws NamingException {
		System.out.println("MLB_bracket, loadbracket, bracket_id: " + bracket_id);
		ArrayList<MLB_Bracket> lb = new ArrayList<MLB_Bracket>();
		
		String sql = "SELECT bracket_id, bracket_seq, p_name, p_team, R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, Other, Matches, gp, DATE(ISRT_TS) as dt FROM apps.mlb_bracket WHERE bracket_id = ? order by bracket_seq asc";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, bracket_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MLB_Bracket b = new MLB_Bracket();
	
				//System.out.println("MLB_bracket, loadbracket within select, bracket_id: " + bracket_id);
				b.setBracket_id(rs.getString(1));
				b.setBracket_seq(rs.getInt(2));
				b.setP_name(rs.getString(3));
				b.setP_team(rs.getString(4));
				b.setR0(rs.getInt(5));
				b.setR1(rs.getInt(6));
				b.setR2(rs.getInt(7));
				b.setR3(rs.getInt(8));
				b.setR4(rs.getInt(9));
				b.setR5(rs.getInt(10));
				b.setR6(rs.getInt(11));
				b.setR7(rs.getInt(12));
				b.setR8(rs.getInt(13));
				b.setR9(rs.getInt(14));
				b.setR10(rs.getInt(15));
				b.setR11(rs.getInt(16));
				b.setR12(rs.getInt(17));
				b.setR13(rs.getInt(18));
				b.setOther(rs.getInt(19));
				b.setMatches(rs.getInt(20));
				b.setGp(rs.getInt(21));
				b.setDt(rs.getString(22));
				lb.add(b);
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
	
		return lb;
	}

	public void insertbracket()  throws NamingException {
		System.out.println("MLB_bracket, insertbracket, bracket_id: " + bracket_id + " bracket_seq: " + bracket_seq);

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.mlb_bracket (bracket_id,bracket_seq,p_name,p_team,R0,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,Other,Matches,gp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {pstmt.setString(1, bracket_id);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(2, bracket_seq);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setString(3, p_name);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setString(4, p_team);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(5, R0);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(6, R1);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(7, R2);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(8, R3);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(9, R4);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(10, R5);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(11, R6);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(12, R7);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(13, R8);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(14, R9);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(15, R10);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(16, R11);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(17, R12);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(18, R13);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(19, Other);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(20, Matches);} catch (SQLException e1) {e1.printStackTrace();}
		try {pstmt.setInt(21, gp);} catch (SQLException e1) {e1.printStackTrace();}
		
		try {
			int iCount = pstmt.executeUpdate();

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
	}

	public String getBracket_id() {
		return bracket_id;
	}

	public void setBracket_id(String bracket_id) {
		this.bracket_id = bracket_id;
	}

	public int getBracket_seq() {
		return bracket_seq;
	}

	public void setBracket_seq(int bracket_seq) {
		this.bracket_seq = bracket_seq;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_team() {
		return p_team;
	}

	public void setP_team(String p_team) {
		this.p_team = p_team;
	}

	public int getR0() {
		return R0;
	}

	public void setR0(int r0) {
		R0 = r0;
	}

	public int getR1() {
		return R1;
	}

	public void setR1(int r1) {
		R1 = r1;
	}

	public int getR2() {
		return R2;
	}

	public void setR2(int r2) {
		R2 = r2;
	}

	public int getR3() {
		return R3;
	}

	public void setR3(int r3) {
		R3 = r3;
	}

	public int getR4() {
		return R4;
	}

	public void setR4(int r4) {
		R4 = r4;
	}

	public int getR5() {
		return R5;
	}

	public void setR5(int r5) {
		R5 = r5;
	}

	public int getR6() {
		return R6;
	}

	public void setR6(int r6) {
		R6 = r6;
	}

	public int getR7() {
		return R7;
	}

	public void setR7(int r7) {
		R7 = r7;
	}

	public int getR8() {
		return R8;
	}

	public void setR8(int r8) {
		R8 = r8;
	}

	public int getR9() {
		return R9;
	}

	public void setR9(int r9) {
		R9 = r9;
	}

	public int getR10() {
		return R10;
	}

	public void setR10(int r10) {
		R10 = r10;
	}

	public int getR11() {
		return R11;
	}

	public void setR11(int r11) {
		R11 = r11;
	}

	public int getR12() {
		return R12;
	}

	public void setR12(int r12) {
		R12 = r12;
	}

	public int getR13() {
		return R13;
	}

	public void setR13(int r13) {
		R13 = r13;
	}

	public int getOther() {
		return Other;
	}

	public void setOther(int other) {
		Other = other;
	}

	public int getMatches() {
		return Matches;
	}

	public void setMatches(int matches) {
		Matches = matches;
	}

	public int getGp() {
		return gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

}
