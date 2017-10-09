package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MVDBHelper {
	Properties properties;
	private static Connection m_CONN;
	private static String LocalUsr = "root";
	private static String LocalPwd = "root";
	private static String LocalUrl = "jdbc:mysql://localhost:3306/apps";

	public MVDBHelper() {
	}
	
	public static Connection getLocalConnection() {
		
		if (m_CONN==null){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	
			try {
				m_CONN = DriverManager.getConnection(LocalUrl, LocalUsr, LocalPwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m_CONN;
	}
}