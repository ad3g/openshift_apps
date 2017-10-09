<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mlb.*" %><%String result = "AssignNumbers.jsp Successfully";
 try 
 {
 	System.out.println("AssignNumbers.jsp");
 	MLBProcessor.AssignPlayers();
 }
 catch (Exception ex)
 {
 		System.out.println(ex.getMessage());
 		result=ex.getMessage().toString();
 }   
 out.print(result);%>