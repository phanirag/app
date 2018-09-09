<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#login-box {
	width: 300px;
	padding: 20px;
	margin: 30px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body background="E:\Images\1020558.jpg" marginheight="50" marginwidth="50">
<h1 align="center">Welcome to  Login Page!!</h1>
<div id="login-box" align="center">
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
Not a registered User? <a href=regUser> click here</a>

</form>
</div>
</body>
</html>