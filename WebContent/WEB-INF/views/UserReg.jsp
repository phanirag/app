<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#reg-box {
	width: 300px;
	padding: 20px;
	margin: 40px auto;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.e {
	color: red;
	font-size: 18px;
}
</style>
<title>User Register Page</title>
</head>
<body>
	<h1 align="center">Welcome to User Register Page!!</h1>
	<div  id="reg-box" align="center">
	<form:form name="formu" action="insertUser" method="POST"
		modelAttribute="user" onsubmit="return ValidateEmail()">
		<table>
			<tr>
				<td>NAME:</td>
				<td><form:input path="userName" type="text" name="userName" />
					<form:errors path="userName" cssClass="e" /></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><form:input path="userEmail" type="text" name="userEmail" />
				</td>
			</tr>
			<tr>
				<td>CONTACT:</td>
				<td><form:input type="text" name="userContact"
						path="userContact" /> <form:errors path="userContact"
						cssClass="e" /></td>
			</tr>
			<tr>
				<td>ADDRESS:</td>
				<td><form:textarea name="userAddress" path="userAddress"></form:textarea>
					<form:errors path="userAddress" cssClass="e" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="register" /></td>
			</tr>
		</table>
	</form:form>
	${msg} Are you Existing User?
	<a href="showLogin">click here</a>
	</div>
	<script>
		function ValidateEmail() {
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			var email = document.forms["formu"]["userEmail"].value;
			if (email.match(mailformat)) {
				return true;
			} else {
				alert("You have entered an invalid email address!");
				return false;
			}
		}
	</script>
	
	<br />
</body>
</html>