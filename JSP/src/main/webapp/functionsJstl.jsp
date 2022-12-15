<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Functions</title>
</head>
<body>

<c:set var="data" value="sun,moon,president,55000"></c:set>
<c:set var="arrData" value="${fn:split(data,',')}"></c:set>

<input type="text" value="${arrData[0]}"/><br>
<input type="text" value="${arrData[1]}"/><br>
<input type="text" value="${arrData[2]}"/><br>
<input type="text" value="${arrData[3]}"/><br>
</body>
</html>