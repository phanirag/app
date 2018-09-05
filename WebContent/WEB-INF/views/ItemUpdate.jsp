<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Edit Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h2>Update Page...</h2>
<form action="updateItem" method="post">
<table>
	<tr>
	<td>id:</td><td><input type="text" name="itemId" value="${Itemobj.itemId}" readonly="readonly"/></td>
</tr>
<tr>
	<td>Name:</td><td><input type="text" name="itemName" value="${Itemobj.itemName}"/></td>
</tr>
<tr>
	<td>Cost:</td><td><input type="text" name="itemCost" value="${Itemobj.itemCost}"/></td>
</tr>
<tr>
	<td>CustID:</td><td><input type="text"name="custId" value="${Itemobj.custId}" readonly="readonly"></td>
</tr>
<tr>
		<td align="center"><input type="submit" value="Update"></td>
</tr>
</table>
</form>
</body>
</html>