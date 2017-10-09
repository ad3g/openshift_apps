<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.pv.*" %>
<%
System.out.println("in EditInfoSave.jsp");
String nme, num, iYr = "";
num=request.getParameter("xnum");
nme=request.getParameter("xnme");
iYr=request.getParameter("xyr");
InfoDAO pDAO = new InfoDAO();
Info p = new Info();
p.setiNum(num);
p.setiName(nme);
p.setiYr(iYr);
pDAO.persistInfo(p);
%>