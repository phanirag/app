<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
  .e{
   color:red;
   font-size: 18px;
  }
</style>
<title>Location Register Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Location Register Page!!</h1>
<form:form action="insertLoc" method="POST" modelAttribute="location">
<table>
<tr>
	<td>NAME:</td>
	<td><form:input path="locName" type="text" name="locName"/>
		<form:errors path="locName" cssClass="e"/>
	</td>
</tr>
<tr>
	<td>CODE:</td>
	<td><form:input  path="locCode" type="text" name="locName"/>
		<form:errors path="locCode" cssClass="e"/>
	</td>
</tr>
<tr>
	<td>TYPE:</td>
	<td><form:radiobutton path="locType" value="Urban" name="locType"/>Urban
	</td>
</tr>
<tr>
	  <td></td><td><form:radiobutton value="Rural" path="locType" name="locType"/> Rural
	  </td>
</tr>
<tr>
	<td>DESCRIPTION:</td><td><form:textarea path="locDesc" name="locDesc"></form:textarea>
							 <form:errors path="locDesc" cssClass="e"/>
	</td>
</tr>
<tr>
	<td></td><td><input type="submit" value="Create"/></td>
</tr>       
</table>
</form:form>
${msg}
<br/></body></html>