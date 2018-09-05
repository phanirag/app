<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Register Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Customer Register Page!!</h1>
<form action="insertcust" method="post">
<table bgcolor="white">
<tr>
	<td>id:</td><td><input type="text" name="custId"/></td>
</tr>
<tr>
	<td>Name:</td><td><input type="text" name="custName"/></td>
</tr>
<tr>
	<td>Email:</td><td><input type="text" name="custEmail"/></td>
</tr>
<tr>
	<td>Type:</td><td><input type="radio" name="custType" value="Consumer"/>Consumer</td>
</tr>
<tr>
	<td></td><td><input type="radio" name="custType" value="Seller"/>Seller</td>
</tr>
<tr>
	<td>Address:</td><td><textarea name="custAddr"></textarea></td>
</tr>
<tr>
	<td><input type="submit" value="submit"/></td>
</tr>
</table>
</form>
</body>
${msg}
</html>
