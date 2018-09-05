<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Recodes</title>
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}

</style>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Location Data Page!!</h3>
<a href="locExcelExport">Export To Excel</a> | <a href="locPdfExport">Export To PDF</a>
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>CODE</th>
	<th>TYPE</th>
	<th>DESCRIPTION</th>
	<th colspan="2">OPERATIONS</th>
</tr>
<c:forEach  items="${locations}" var="loc">
<tr>
 <td><c:out value="${loc.locId}"/></td>
 <td><c:out value="${loc.locName}"/></td>
 <td><c:out value="${loc.locCode}"/></td>
 <td><c:out value="${loc.locType}"/></td>
 <td><c:out value="${loc.locDesc}"/></td>
 <td>
 	<a href="deleteLoc?locId=${loc.locId}">
 		<img  src="../images/delete.png" width="30" height="30">
 	</a>
 </td>
 <td>
 	<a href="editLoc?locId=${loc.locId}">
 		<img src="../images/edit.png" width="30" height="30"/>
 	</a>
 </td>
 
</tr> 
</c:forEach>
</table>

</body>
</html>