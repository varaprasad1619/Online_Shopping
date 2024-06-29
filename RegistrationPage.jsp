<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body align="center">
<form action="./osRegister" method="post">
Name:
<input type="text" name="name"/></br>
Email-id:
<input type="email" name="email"/></br>
Password:
<input type="password" name="password"/></br>
Mobile No:
<input type="text" name="number"/></br>
<input type="submit" value="Regsiter" />
</form>
<a href="HomePage.jsp" >Back</a></br>
</body>
</html>