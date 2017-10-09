<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %>
<%
System.out.println("in EditInfoSave.jsp");
String nme, num = "";
num=request.getParameter("xnum");
nme=request.getParameter("xnme");
InfoDAO pDAO = new InfoDAO();
Info p = new Info();
p.setiNum(num);
p.setiName(nme);
pDAO.persistInfo(p);
%>