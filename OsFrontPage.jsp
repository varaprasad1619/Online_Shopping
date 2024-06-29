<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<a href="ProfilePage.jsp" ><button style="background-color:brown;color:white;width:70px;height:30px;width:100px">My Profile</button></a>
<meta charset="ISO-8859-1">
<title>Shopping Front Page</title>
</head>
<body align="center">
<h2 align="center">Welcome to the Mobile Store</h2></br>
<h3>
<%
String name=(String)session.getAttribute("Name");  
out.print("Hello, "+name);
%>
</h3>

 <form action="AddToCartServlet" method="post">
<div class="card">
  <img src="productImages/2.jfif" style="width:10%">
  <h3>Redmi note 9</h3>
  <p class="price">Rs.2000</p>
  <p>Super product with 4gb ram</p>
  <input type="hidden" name="productName" value="Redmi note 9">
  <input type="hidden" name="price" value="2000">
  <p><button type="submit">Add to Cart</button></p>
</div>
</form>

<form action="AddToCartServlet" method="post">
<div class="card">
  <img src="productImages/3.jfif" style="width:17%">
  <h3>Iphone 14</h3>
  <p class="price">Rs.30000</p>
  <p>Super product with 8gb ram</p>
  <input type="hidden" name="productName" value="Iphone 14">
  <input type="hidden" name="price" value="30000">
  <p><button type="submit">Add to Cart</button></p>
</div>
</form>
<form action="cartPageBackend" method="post">
  <p><button type="submit" style="background-color:green;color:white;width:150px;height:50px;width:200px">Go to Cart</button></p>
  </form>
  <a href="LoginPage.jsp" ><p><button style="background-color:black;color:white;width:100px;height:50px;width:200px">LOG OUT</button></p></a>

</body>
</html>