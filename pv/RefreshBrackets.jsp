<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.pv.*" %>
<%
//System.out.println("in AssignNumbers.jsp");
//GameDAO gDAO = new GameDAO();
//gDAO.refreshBrackets(request.getParameter("xYr"));

System.out.println("in RefreshBracket.jsp xyr: " + request.getParameter("xyr"));
GameDAO gDAO = new GameDAO();
gDAO.refreshBrackets(request.getParameter("xyr"));
%>