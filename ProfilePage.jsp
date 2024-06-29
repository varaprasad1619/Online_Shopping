<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>My Profile Page</title>
</head>
<body class="container" align="center">
<i class="glyphicon glyphicon-user"></i>
<%
	String name = (String) session.getAttribute("Name");
	out.print("Hi " +name+ ",You can access all your relevant information here");
%>
<a href="OsFrontPage.jsp" ><p><button style="background-color:#0096FF;color:white;width:100px;height:25px;width:50px">Home</button></p></a>
<form action="MyOrdersPageBackend" method="post">
<p><button type="submit" style="background-color:black;color:white;width:100px;height:40px;width:100px">My Orders</button></p>
</form>
<form action="cartPageBackend" method="post">
<p><button type="submit" style="background-color:green;color:white;width:100px;height:50px;width:150px">Go to Cart</button></p>
</form>
</body>
</html>