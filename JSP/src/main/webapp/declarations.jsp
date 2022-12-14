<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>declarations</title>
</head>
<body>

<h1>


</h1>
<%!
private int result;

public int sum(int num1, int num2){
	return num1+num2;
}

%>

5+9 is =<%= sum(5,9) %>



</body>
</html>