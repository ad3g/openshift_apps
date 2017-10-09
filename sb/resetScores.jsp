<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.sb.*" %><%
 String result = "Score Reset Successfully";
 try 
 {
 	System.out.println("resetScores");
 	Scores sc = new Scores();
	sc.resetScores();
 }
 catch (Exception ex)
 {
 		System.out.println(ex.getMessage());
 		result=ex.getMessage().toString();
 }   
 out.print(result); 
%>