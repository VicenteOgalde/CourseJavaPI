<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Product</title>
</head>
<body>
<form method="get" action="ProductController">
<input type="hidden" name="quest" value="newProduct">

Id:<input type="text" name="id"><br>

Name:<input type="text" name="name"><br>

Section:<input type="text" name="section"><br>

Price:<input type="number" name="price"><br>

Date:<input type="date" name="date"><br>



<input type="submit" value="Insert Product">

</form>

</body>
</html>