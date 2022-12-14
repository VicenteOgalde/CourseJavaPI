<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Collect Data</title>
</head>
<body>

<%
String name= request.getParameter("name");
String surname= request.getParameter("surname");
String user= request.getParameter("user");
String password= request.getParameter("password");
String country= request.getParameter("country");
String tech= request.getParameter("tech");

Connection conn=DriverManager.getConnection("jdbc:mysql//localhost:3306/jsp_project");

Statement statement= conn.createStatement();

String sqlInfo="Insert into user(name,surname,user,password,country,tech)"+
	" Values ('"+name+"','"+surname+"','"+user+"','"+password+"','"+country+"','"+tech+"')";
statement.executeUpdate(sqlInfo);

out.println("Register OK");


%>
</body>
</html>