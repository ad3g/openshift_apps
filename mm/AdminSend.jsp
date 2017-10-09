<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mm.*" %>
<%
System.out.println("in AdminSend.jsp");
System.out.println("value: " + request.getParameter("ky"));


WinnerDAO w = new WinnerDAO();
if (request.getParameter("ky").equals("del")){
	out.print(w.deleteAll());
}
else
{
	out.print(w.loadMatches());
}
%>