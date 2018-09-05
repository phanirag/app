<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}
</style>
<title>Customer Recodes</title>
</head>
<%@include file="UserMenu.jsp" %>
<body>
<h1>View All Records...</h1>
<a href="custexeclexport">Export To Excel</a> | <a href="custpdfexport">Export To PDF</a>
<table border="1">
<tr>
 <th>CUSTOMER ID</th>
 <th>CUSTOMER NAME</th>
 <th>CUSTOMER EMAIL</th>
 <th>CUSTOMER TYPE</th>
 <th>CUSTOMER ADDRESS</th>
 <th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="l">
<tr>
<td><c:out value="${l.custId}"/></td>
<td><c:out value="${l.custName}"/></td>
<td><c:out value="${l.custEmail}"/></td>
<td><c:out value="${l.custType}"/></td>
<td><c:out value="${l.custAddr}"/></td>
<td>
	<a href="deletecust?custId=${l.custId}">
		 	<img  src="../images/delete.png" width="30" height="30">
	</a>
</td>
<td>
	<a href="updatecust?custId=${l.custId}">
		 	<img src="../images/edit.png" width="30" height="30"/>
	</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>