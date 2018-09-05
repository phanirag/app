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
<a href="Orderexeclexport">Export To Excel</a> | <a href="Orderpdfexport">Export To PDF</a>
<table border="1">
<tr>
 <th>ORDER ID</th>
 <th>ORDER CODE</th>
 <th>ORDER COST</th>
 <th>ITEM NAME</th>
 <th>CUSTOMER ID</th>
 <th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="l">
<tr>
<td><c:out value="${l.orderId}"/></td>
<td><c:out value="${l.orderCode}"/></td>
<td><c:out value="${l.orderCost}"/></td>
<td><c:out value="${l.iName}"/></td>
<td><c:out value="${l.custId}"/></td>
<td>
	<a href="deleteOrder?OrderId=${l.orderId}">
	 	<img  src="../images/delete.png" width="30" height="30">
	</a>
</td>
<td>
	<a href="updateOrderID?OrderId=${l.orderId}">
	 	<img  src="../images/edit.png" width="30" height="30"/>
	</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>