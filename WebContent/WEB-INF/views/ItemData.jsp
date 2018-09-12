<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Item Recodes</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}
</style>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>View All Records...</h1>
<a href="Itemexeclexport">Export To Excel</a> | <a href="Itempdfexport">Export To PDF</a>
<table border="1">
<tr>
 <th>ITEM ID</th>
 <th>ITEM NAME</th>
 <th>COST</th>
 <th>CUSTOMER ID</th>
 <th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="l">
<tr>
<td><c:out value="${l.itemId}"/></td>
<td><c:out value="${l.itemName}"/></td>
<td><c:out value="${l.itemCost}"/></td>
<td><c:out value="${l.custId.custId}"/></td>
<td>
	<a href="deleteItem?itemId=${l.itemId}">
	 	<img  src="../images/delete.png" width="30" height="30">
	</a>
</td>
<td>
	<a href="updateID?itemId=${l.itemId}">
	 	<img  src="../images/edit.png" width="30" height="30"/>
	</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>