<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>

<form name="shopForm" action="shoppingCar.jsp">
 
  <p>Items to buy:</p>
  <p>
    <label>
      <input type="checkbox" name="items" value="water" >
      water </label>
    <br>
    <label>
      <input type="checkbox" name="items" value="milk" >
      milk </label>
    <br>
     <label>
      <input type="checkbox" name="items" value="bread" >
      bread </label>
    <br>
     <label>
      <input type="checkbox" name="items" value="apple" >
      apple </label>
    <br>
     <label>
      <input type="checkbox" name="items" value="meat" >
      meat </label>
      <br>
       <label>
      <input type="checkbox" name="items" value="fish" >
      fish </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Send">
    <br>
  </p>
</form>

<br>

<h2>Shopping cart</h2>

<%

List<String> cart=(List<String>)session.getAttribute("cart");

if(cart == null){
	cart=new ArrayList<String>();
	session.setAttribute("cart", cart);
}

String [] cartS=request.getParameterValues("items");

if(cartS!=null){
	for(String item:cartS){
		cart.add(item);
		
		//out.println("<li>"+item+"</li>");
	}
}
for(String item:cart){
	out.println("<li>"+item+"</li>");
}

%>


</body>
</html>