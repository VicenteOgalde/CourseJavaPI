<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String students[]={"sun","moon","greg"};

pageContext.setAttribute("students", students);

%>

<c:forEach var="tempStudent" items="${students}">

${tempStudent}<br>


	

</c:forEach>



</body>
</html>