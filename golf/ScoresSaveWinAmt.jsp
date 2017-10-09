<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %>
<%
System.out.println("in ScoresSaveWinAmt.jsp");
String amt, id = "";
id=request.getParameter("xId");
System.out.println("id: " + id);
amt=request.getParameter("xAmt");
System.out.println("Amt: " + amt);
ScoresDao sDao = new ScoresDao();

Score s = new Score();
s.setsId(Integer.parseInt(id));
sDao.loadScore(s);
s.setWinAmt(Double.parseDouble(amt));
sDao.persistScore(s);
%>