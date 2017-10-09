<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.sb.*" %><%
 String result = "Add Score Successfully";
 try 
 {
 	String Qtr = request.getParameter("Qtr");
 	String Div = request.getParameter("Div");
 	String Pts = request.getParameter("Pts");
 	System.out.println("addScores, Qtr: " + Qtr + " Div: " + Div + " Pts: " + Pts);
 	Scores sc = new Scores();
 	sc.setQtr(Qtr);
	sc.setDivision(Div);
	sc.setPTS(Pts);
	sc.insertScore();
 }
 catch (Exception ex)
 {
 		System.out.println(ex.getMessage());
 		result=ex.getMessage().toString();
 }   
 out.print(result); 
%>