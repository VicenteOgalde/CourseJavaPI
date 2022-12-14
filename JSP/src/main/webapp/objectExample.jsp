<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Objects example</title>
</head>
<body>

<h2>predefined objects</h2>

<p>browser data request <%= request.getHeader("User-Agent") %>
</p>

<br>

<p>language : <%= request.getLocale() %>
</p>
</body>
</html>