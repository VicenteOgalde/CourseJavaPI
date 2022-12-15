<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel here</title>
</head>
<body>

<h1>Travel Agency</h1>

<%
String favoriteCity="Madrid";

Cookie [] cookies=request.getCookies();

if(cookies!=null){
	for(Cookie c:cookies){
		if("city".equals(c.getName())){
			favoriteCity=c.getValue();
			break;
		}
	}
}


%>

<h2>fly to <%=favoriteCity %></h2>


</body>
</html>