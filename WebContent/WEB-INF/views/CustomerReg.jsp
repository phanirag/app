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
<title>Customer Register Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Customer Register Page!!</h1>
<form:form action="insertcust" method="POST" modelAttribute="customer">
<table bgcolor="white">
<tr>
	<td>Name:</td>
	<td><form:input path="custName" type="text" name="custName"/>
		<form:errors path="custName" cssClass="e"/>
	</td>
</tr>
<tr>
	<td>Email:</td>
	<td><form:input type="text" name="custEmail" path="custEmail"/>
		<form:errors path="custEmail" cssClass="e"/>
	</td>
</tr>
<tr>
	<td>Type:</td>
	<td><form:radiobutton name="custType" path="custType" value="Consumer"/>Consumer
	</td>
</tr>
<tr>
	<td></td><td><form:radiobutton name="custType" path="custType" value="Seller"/>Seller
	</td>
</tr>
<tr>
	<td>Address:</td>
	<td><form:textarea name="custAddr" path="custAddr"></form:textarea>
		<form:errors path="custAddr" cssClass="e"/>
	</td>
</tr>
<tr>
	<td><input type="submit" value="submit"/></td>
</tr>
</table>
</form:form>
</body>
${msg}
</html>
