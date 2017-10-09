<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %>
<%
System.out.println("in ScoresSaveClosestTo.jsp");
String nme, num = "";
num=request.getParameter("xId");
System.out.println("num: " + num);
nme=request.getParameter("xClosestTo");
System.out.println("nme: " + nme);
ScoresDao sDao = new ScoresDao();

Score s = new Score();
s.setsId(Integer.parseInt(num));
sDao.loadScore(s);
s.setsClosestTo(nme);
sDao.persistScore(s);
%>