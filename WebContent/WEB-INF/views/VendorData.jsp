 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Records</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Vendor Data Page!!</h1>
<a href="venExcelExport">Export To Excel</a> | <a href="venPdfExport">Export To PDF</a>
<table border="1">
 <tr>
 	<th>ID</th>
 	<th>CODE</th>
 	<th>NAME</th>
 	<th>TYPE</th>
 	<th>ADDRESS</th>
 	<th>ID TYPE</th>
 	<th>ID NUM</th>
 	<th>NOTE</th>
 	<th colspan="2">OPERATIONS</th>
 </tr>
 <c:forEach items="${vendors}" var="ven">
 <tr>
 	<td><c:out value="${ven.venId}"/></td>
 	<td><c:out value="${ven.venCode}"/></td>
 	<td><c:out value="${ven.venName}"/></td>
 	<td><c:out value="${ven.venType}"/></td>
 	<td><c:out value="${ven.venAddr}"/></td>
 	<td><c:out value="${ven.idType}"/></td>
 	<td><c:out value="${ven.idNum}"/></td>
 	<td><c:out value="${ven.dsc}"/></td>
 	<td>
 	<a href="deleteVen?venId=${ven.venId}">
 		<img  src="../images/delete.png" width="30" height="30">
 	</a> 
 	</td>
 	<td>
 	<a href="editVen?venId=${ven.venId}">
 		<img src="../images/edit.png" width="30" height="30"/>
 	</a>
 	</td>
 </tr>
 </c:forEach>
</table>

</body>
</html>