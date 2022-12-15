<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="com.example.jspTAG.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show User</title>
</head>
<body>

<%
ArrayList <UserE> data= new ArrayList<UserE>();
try{
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project","root","");
	Statement st= conn.createStatement();
	
	String sqlQ="Select * from user";
	ResultSet rs=st.executeQuery(sqlQ);
	while(rs.next()){
		data.add(new UserE(rs.getInt("id"),rs.getString("name"),
				rs.getString("surname"),rs.getString("user"),rs.getString("password")
				,rs.getString("country"),rs.getString("tech")));
		
	}
	rs.close();
	conn.close();
}catch(Exception e){
	out.println("error connection");
}
pageContext.setAttribute("data", data);


%>
<table border="1">
<tr>
<td>ID</td><td>Name</td><td>Tech</td><td>FrameWork</td> 
</tr>
<c:forEach var="user" items="${data}">
<tr><td>${user.id}</td><td>${user.name}</td><td>${user.tech}</td>

<td><c:if test="${user.tech.equals('Java')}">Spring</c:if>
	<c:if test="${user.tech.equals('PHP')}">Laravel</c:if>
	<c:if test="${user.tech.equals('JavaScript')}">NodeJS</c:if>

</td> 

</tr>


</c:forEach>
</table>	
</body>
</html>