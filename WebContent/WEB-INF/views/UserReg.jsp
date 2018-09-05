<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Register Page</title>
</head>
<body>
<h1>Welcome to User Register Page!!</h1>
<form action="insertUser" method="post">
<table>
<tr>
	<td>NAME:</td><td><input type="text" name="userName"/></td>
</tr>
<tr>
	<td>EMAIL:</td><td><input type="text" name="userEmail"/></td>
</tr>
<tr>
	<td>CONTACT:</td><td><input type="text" name="userContact"/></td>
</tr>
<tr>
	<td>ADDRESS:</td><td><textarea name="Address"></textarea></td>
</tr>
<tr>
	<td></td><td><input type="submit" value="register"/></td>
</tr>       
</table>
</form>
${msg}
Are you Existing User?<a href="showLogin">click here</a>
<br/></body></html>