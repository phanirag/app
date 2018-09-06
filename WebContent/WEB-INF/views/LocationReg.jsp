<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Register Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Location Register Page!!</h1>
<form action="insertLoc" method="post">
<table>
<tr>
	<td>NAME:</td><td><input type="text" name="locName"/></td>
</tr>
<tr>
	<td>CODE:</td><td><input type="text" name="locCode"/></td>
</tr>
<tr>
	<td>TYPE:</td><td><input type="radio" name="locType" value="Urban"> Urban</td>
</tr>
<tr>
	  <td></td><td><input type="radio" name="locType" value="Rural"> Rural</td>
</tr>
<tr>
	<td>DESCRIPTION:</td><td><textarea name="locDesc"></textarea></td>
</tr>
<tr>
	<td></td><td><input type="submit" value="Create"/></td>
</tr>       
</table>
</form>
${msg}
<br/></body></html>