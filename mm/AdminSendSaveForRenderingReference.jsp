<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mm.*" %>
<%
System.out.println("in AdminSend.jsp");
String fname = "";
String city = "";
fname=request.getParameter("name");
city=request.getParameter("city");
out.print("Dear " + fname + ". ");
out.print("Hope you live well in " + city + ".");
%>