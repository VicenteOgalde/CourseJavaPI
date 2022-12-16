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
<style type="text/css">
.header{
font-size: 1.2em;
font-weight: bold;
color: #FFFFFF;
background-color: blue;

}

.rows{
text-align: center;
background-color: #5882FA;

}
table{
float:left;
}
#buttonContainer{
margin-left: 300px;

}
</style>

</head>


<body>


<table>
<tr>
<td class="header">Id</td>
<td class="header">Name</td>
<td class="header">Section</td>
<td class="header">Price</td>
<td class="header">Date</td>

</tr>
<c:forEach var="e" items="${products}">


<tr>
<td class="rows">${e.id}</td>
<td class="rows">${e.name}</td>
<td class="rows">${e.section}</td>
<td class="rows">${e.price}</td>
<td class="rows">${e.date}</td>

</tr>
</c:forEach>

</table>

<div id="buttonContainer">
	<input type="button" value="Insert new Product" onclick="window.location.href='insertProduct.jsp'"/>

</div>











</body>
</html>