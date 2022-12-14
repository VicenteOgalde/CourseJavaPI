<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Login</h1>

<table width="35%" border="0">
		
		<form action="userCheck.jsp" method="post">
			<tr>
				<td width="13%"><label for="user">user: </label></td>
				<td width="87%"><input type="text" name="user" id="user"></td>
			</tr>
			<tr>
				<td width="13%"><label for="password">password: </label></td>
				<td width="87%"><input type="password" name="password" id="password"></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center"><input type=submit name="button"
					id="button" value="Login"></td>
			</tr>

			
				<br>
			
		</table>

	</form>


</body>
</html>