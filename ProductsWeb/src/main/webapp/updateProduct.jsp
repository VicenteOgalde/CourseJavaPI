<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>

<form method="get" action="ProductController">
<input type="hidden" name="quest" value="updateProductX">
<input type="hidden" name="id" value="${pTemp.id}">
<label  >${pTemp.id}</label>
<br>

Name:<input type="text" name="name" value="${pTemp.name}"> <br>

Section:<input type="text" name="section" value="${pTemp.section}"><br>

Price:<input type="number" name="price" value="${pTemp.price}"><br>

Date:<input type="date" name="date" value="${pTemp.date}"><br>



<input type="submit" value="Update Product">

</form>

</body>
</html>