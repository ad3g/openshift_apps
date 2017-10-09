<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %>
<%
System.out.println("in PlayerAddEditSub.jsp");
String id, nme, eml, ph = "";
id=request.getParameter("xId");
System.out.println("id: " + id);
nme=request.getParameter("xNme");
System.out.println("nme: " + nme);
eml=request.getParameter("xEml");
System.out.println("eml: " + eml);
ph=request.getParameter("xPh");
System.out.println("ph: " + ph);
PlayerDao pDao = new PlayerDao();
Player p = new Player();
p.setpId(Integer.parseInt(id));
p.setpName(nme);
p.setpEmail(eml);
p.setpPhone(ph);
pDao.persistPlayer(p);
%>