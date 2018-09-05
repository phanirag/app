<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Welcome to  Login Page!!</h1>
<form action="loginCheck" method="post">
<table>
<tr>
	<td>UserName:</td><td><input type="text" name="userName"/></td>
</tr>
<tr>
	<td>Password:</td><td><input type="password" name="Password"/></td>
</tr>
<tr>
	<td><input type="submit" value="login"/></td>
</tr>
${msg}
</table>
</form>
Not a registered User? <a href=regUser> click here</a>
</body>
</html>