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
<title>Vendor Registration Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Vendor Register Page!!</h1>
<form:form action="insertVen" method="POST" modelAttribute="vendor">
<table>
<tr>
	<td>NAME:</td>
	<td><form:input type="text" name="venName" path="venName"/>
		<form:errors path="venName" cssClass="e"/>
	</td>
<tr>
<tr>
	<td>CODE:</td>
	<td><form:input type="text" name="venCode" path="venCode"/>
		<form:errors path="venCode" cssClass="e"/>
	</td>
<tr>
<tr>
	<td>TYPE:</td>
	<td><form:radiobutton name="venType" path="venType" value="CONTRACT"/>CONTRACT
	</td>
</tr>
<tr>
   <td></td>
   <td><form:radiobutton name="venType" path="venType" value="FULLTIME"/>FULLTIME
	</td>
</tr>
<tr>
   <td></td>
   <td><form:radiobutton name="venType" path="venType" value="PARTTIME"/>PARTTIME
   </td>
</tr>
<tr>
	<td>ADDRESS:</td><td><form:textarea name="venAddr" path="venAddr"></form:textarea>
						 <form:errors path="venAddr" cssClass="e"/>
	</td>
</tr>
<tr>
<td>ID TYPE:</td><td><form:select name="idType" path="idType">
			<option value="">--select--</option>
			<option value="PAN">PAN</option>
			<option value="AADHAR">AADHAR</option>
			<option value="VOTER ID">VOTER ID</option>
			<option value="other">other</option>
		</form:select> </td>  
</tr>
<tr>
	<td>ID NUM:</td>
	<td><form:input type="text" name="idNum" path="idNum"/>
		<form:errors path="idNum" cssClass="e"/>
	</td>
</tr>
<tr>
	<td>NOTE:</td><td><form:textarea name="dsc" path="dsc"></form:textarea>
					  <form:errors path="dsc" cssClass="e"/>
	</td>
</tr>
<tr>
	<td></td><td><input type="submit" value="Register"/></td>
</tr>		
</table>
</form:form>
${msg}
</body>
</html>