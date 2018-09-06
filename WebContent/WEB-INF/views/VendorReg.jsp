<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Registration Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<h1>Welcome to Vendor Register Page!!</h1>
<form action="insertVen" method="post">
<table>
<tr>
	<td>NAME:</td><td><input type="text" name="venName"/></td>
<tr>
<tr>
	<td>CODE:</td><td><input type="text" name="venCode"/></td>
<tr>

<tr>
	<td>TYPE:</td><td><input type="radio" name="venType" value="CONTRACT">CONTRACT</td>
</tr>
<tr>
   <td></td><td><input type="radio" name="venType" value="FULLTIME">FULLTIME</td>
</tr>
<tr>
   <td></td><td><input type="radio" name="venType" value="PARTTIME">PARTTIME</td>
</tr>
<tr>
	<td>ADDRESS:</td><td><textarea name="venAddr"></textarea></td>
</tr>
<tr>
<td>ID TYPE:</td><td><select name="idType">
			<option value="">--select--</option>
			<option value="PAN">PAN</option>
			<option value="AADHAR">AADHAR</option>
			<option value="VOTER ID">VOTER ID</option>
			<option value="other">other</option>
		</select> </td>  
</tr>
<tr>
	<td>ID NUM:</td><td><input type="text" name="idNum"/></td>
</tr>
<tr>
	<td>NOTE:</td><td><textarea name="dsc"></textarea></td>
</tr>
<tr>
	<td></td><td><input type="submit" value="Register"/></td>
</tr>		
</table>
</form>
${msg}
</body>
</html>