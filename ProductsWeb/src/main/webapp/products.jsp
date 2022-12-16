<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.VO.products.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>


<body>


<table>
<tr>
<td>Id</td>
<td>Name</td>
<td>Section</td>
<td>Price</td>
<td>Date</td>

</tr>
<c:forEach var="e" items="${products}">


<tr>
<td>${e.getId()}</td>
<td>${e.getName()}</td>
<td>${e.getSection()}</td>
<td>${e.getPrice()}</td>
<td>${e.getDate()}</td>

</tr>
</c:forEach>

</table>

</body>
</html>