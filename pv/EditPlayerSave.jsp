<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.pv.*" %>
<%
//System.out.println("in EditPlayerSave.jsp");
String yr, nme, num = "";
num=request.getParameter("xnum");
nme=request.getParameter("xnme");
yr=request.getParameter("xyr");
PlayerDAO pDAO = new PlayerDAO();
Player p = new Player();
p.setpNum(num);
p.setpName(nme);
p.setpYr(yr);
pDAO.persistPlayer(p);
%>