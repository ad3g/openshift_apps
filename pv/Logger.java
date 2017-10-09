package com.pv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Jeff Mitchell -- Logs all the messages/errors
 * 	This class will logs processing messages and counts.
 *  
 */
public class Logger {

	static File logdir = null;
	public static String logfilename;
	
	//Load Report
	static File reportdir = null;
	static String loadFileName;
		
	/**
	 * @param message
	 */
	public static void log(String message, String level) {
		try {
			if (!message.equals("null") && !message.trim().equals("")) {
				
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logfilename, true)));
				String logMessage = level + " [" + getDateTime() + "] " + message;
				out.println(logMessage);
				out.close();
				
				System.out.println(logMessage);
				
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}

	/**
	 * @param message
	 */
	public static void writeLoadReport(String message) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(loadFileName, true)));
			out.println(message);
			out.close();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/**
	 * @return datetime
	 */
	public final static String getDateTime() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd_hhmmss");
		return df.format(new Date());
	}
	
	/**
	 * @return datetime
	 */
	public final static String getFormatDateTime() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		return df.format(new Date());
	}

	public static boolean DefineLogFile() {
	
		try {
			logdir = new File("C:\\MainframeCodeGenerator\\Log\\MainframeCodeGenerator_" + getDateTime()	+ ".log");
			//logdir = new File("../../../logs/EIMS/HL7Parser/HL7ParserLog" + getDateTime()	+ ".log");
			logfilename = logdir.getCanonicalPath(); 
			log("Logfile Name: " + logdir.getName() , "Info");
		} catch (Exception ex){
			return false;
		}
		
		// Tests whether the directory denoted by this abstract pathname exists.
		boolean exists = logdir.exists();
		
		
		return exists;
	}
	
	/**
	 * @throws Exception
	 */
	public static boolean DefineLoadReportFile(String rptFileDir,String Copybook) {
		reportdir = new File(rptFileDir);
		loadFileName = rptFileDir + "HL7LoadReport_" + Copybook + "_"+ getDateTime()	+ ".txt";
		
		// Tests whether the directory denoted by this abstract pathname exists.
		boolean exists = reportdir.exists();
		return exists;
	}
	
	
}
