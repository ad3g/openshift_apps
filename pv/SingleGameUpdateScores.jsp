<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.pv.*" %>
<%
System.out.println("in UpdateScores.jsp xyr: " + request.getParameter("xyr"));
GameDAO gDAO = new GameDAO();
gDAO.testUpdateScores(request.getParameter("xyr"));
gDAO.refreshBrackets(request.getParameter("xyr"));
%>