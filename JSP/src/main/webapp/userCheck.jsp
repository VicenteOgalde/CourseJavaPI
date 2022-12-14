
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check User</title>
</head>
<body>

<%

String user= request.getParameter("user");
String password= request.getParameter("password");
try{
Class.forName("com.mysql.jdbc.Driver");

Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project","root","");

PreparedStatement pStatement= conn.prepareStatement("Select * from user where user=? and password=?");

pStatement.setString(1, user);
pStatement.setString(2, password);
ResultSet rs= pStatement.executeQuery();

if(rs.absolute(1)){
	out.println("User ok");
}else{
	out.println("User not ok");
}
}catch(Exception e){
	out.println("Error");
}




%>
</body>
</html>