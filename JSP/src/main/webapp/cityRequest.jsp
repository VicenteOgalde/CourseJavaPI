<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favorite city</title>
</head>
<body>

<%
String city= request.getParameter("city");

Cookie cookie= new Cookie("city",city);

cookie.setMaxAge(365*24*60*60);//1 year = 365 days* 24 hours*60 minutes* 60 seconds

response.addCookie(cookie);

%>
Preference Saved

<a href="travel.jsp">Choose a fly</a>

</body>
</html>