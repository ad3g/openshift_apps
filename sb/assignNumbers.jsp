<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.sb.*" %><%String result = "Numbers Assigned Successfully";
 try 
 {
 	System.out.println("assignNumbers");
 	Game gm = new Game();
 	gm.assignNumbers();
 }
 catch (Exception ex)
 {
 		System.out.println(ex.getMessage());
 		result=ex.getMessage().toString();
 }   
 out.print(result);%>