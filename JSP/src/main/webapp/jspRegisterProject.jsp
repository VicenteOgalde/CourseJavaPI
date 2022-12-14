<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Project</title>
</head>
<body>

	<h1>User Register  JSP</h1>

	<form action="collectData.jsp" method="post">

		<table width="35%" border="0">
			<tr>
				<td width="13%"><label for="name">name: </label></td>
				<td width="87%"><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td width="13%"><label for="surname">surname: </label></td>
				<td width="87%"><input type="text" name="surname"
					id="surname"></td>
			</tr>
			<tr>
				<td width="13%"><label for="user">user: </label></td>
				<td width="87%"><input type="text" name="user" id="user"></td>
			</tr>
			<tr>
				<td width="13%"><label for="password">password: </label></td>
				<td width="87%"><input type="text" name="password" id="password"></td>
			</tr>
			<tr>

				<td><label for="country">country</label></td>
				<td><select name="country" id="country">

						<option>Mexico</option>
						<option>Colombia</option>
						<option>Chile</option>
						<option>Peru</option>
						<option>Argentina</option>
						<option>España</option>

				</select></td>
			</tr>
			<tr>
				<td>Tech</td>
				<td><label> <input type="radio" name="tech"
						value="Java" id="tech1"> Java
				</label> <br> <label> <input type="radio" name="tech"
						value="PHP" id="tech2"> PHP
				</label> <br> <label> <input type="radio" name="tech"
						value="JavaScript" id="tech3"> JavaScript
				</label></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type=submit name="button"
					id="button" value="Send"></td>
			</tr>

			
				<br>
			
		</table>

	</form>




</body>
</html>