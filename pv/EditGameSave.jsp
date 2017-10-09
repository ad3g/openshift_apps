<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.pv.*" %>
<%
System.out.println("in EditGameSave.jsp");

//System.out.println("gt1num: " + request.getParameter("gt1num"));
		
GameDAO gDAO = new GameDAO();		
Game g = new Game();
g.setT1NAME(request.getParameter("g1Name"));
g.setT1S1(request.getParameter("t1s1"));
g.setT1S2(request.getParameter("t1s2"));
g.setT1S3(request.getParameter("t1s3"));
g.setT1S4(request.getParameter("t1s4"));
g.setT1SF(request.getParameter("t1sF"));

g.setT2NAME(request.getParameter("g2Name"));
g.setT2S1(request.getParameter("t2s1"));
g.setT2S2(request.getParameter("t2s2"));
g.setT2S3(request.getParameter("t2s3"));
g.setT2S4(request.getParameter("t2s4"));
g.setT2SF(request.getParameter("t2sF"));

g.setgName(request.getParameter("gname"));
g.setLoc(request.getParameter("gloc"));
g.setDte(request.getParameter("gdte"));
g.setTv(request.getParameter("gtv"));

//g.setWin1(request.getParameter("gwin1"));
g.setWin2(request.getParameter("gwin2"));
//g.setWin3(request.getParameter("gwin3"));
//g.setWin4(request.getParameter("gwin4"));
g.setWinF(request.getParameter("gwinF"));

//g.setPay1(request.getParameter("gpay1"));
g.setPay2(request.getParameter("gpay2"));
//g.setPay3(request.getParameter("gpay3"));
//g.setPay4(request.getParameter("gpay4"));
g.setPayF(request.getParameter("gpayF"));

g.setgNum(request.getParameter("gnum"));
g.setT1NUM(request.getParameter("gt1num"));
g.setT2NUM(request.getParameter("gt2num"));
//g.setBracketHtml(request.getParameter("gbracket"));
g.setpNum(request.getParameter("gpnum"));
g.setgYr(request.getParameter("gyr"));

gDAO.persistGame(g);
gDAO.refreshBracket(g);
%>