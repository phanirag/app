<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Edit Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h2>Update Page...</h2>
<form action="updateCustomer" method="post">
<table>
	<tr>
	<td>id:</td><td><input type="text" name="custId" value="${custObj.custId}" readonly="readonly"/></td>
</tr>
<tr>
	<td>Name:</td><td><input type="text" name="custName" value="${custObj.custName}"/></td>
</tr>
<tr>
	<td>Email:</td><td><input type="text" name="custEmail" value="${custObj.custEmail}"/></td>
</tr>
<tr><td>Type</td><td><c:choose>
	<c:when test="${'Consumer' eq custObj.custType}">
		<input type="radio" name="custType" value="Consumer" checked="checked" />Consumer<br>
		<input type="radio" name="custType" value="Seller" />Seller<br>
	</c:when>
	<c:otherwise>
		<input type="radio" name="custType" value="Consumer" />Consumer<br>
		<input type="radio" name="custType" value="Seller" checked="checked"/>Seller<br>
	</c:otherwise></c:choose>
</tr>
<tr>
	<td>Address:</td><td><textarea name="custAddr" >${custObj.custAddr}</textarea></td>
</tr>
<tr>
		<td><input type="submit" value="Update"></td><td></td>
</tr>
</table>
</form>
</body>
</html>