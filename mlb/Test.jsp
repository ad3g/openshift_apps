<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mlb.*" %><%String result = "Test.jsp Successfully";
 try 
 {
 	System.out.println("Test.jsp");
 	MLBProcessor.LoadSingleDayOfYear("2016-04-13");
 }
 catch (Exception ex)
 {
 		System.out.println(ex.getMessage());
 		result=ex.getMessage().toString();
 }   
 out.print(result);%>