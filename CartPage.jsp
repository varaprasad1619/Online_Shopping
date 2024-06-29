<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Cart</title>
</head>

<body align="center">
	<h4>Your selected products will appear here</h4>
	<%
	String name = (String) session.getAttribute("Name");
	out.print(name + ",You are ready to buy the products");
	%>
	 <% 
	 Map<String, String> pname = (Map<String, String>) request.getAttribute("hm");
	 Iterator<Map.Entry<String, String>> iterator = pname.entrySet().iterator();
	 %>


<table align="center" border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
 
    <% while (iterator.hasNext()) {
        Map.Entry<String, String> entry = iterator.next();
        String name1 = entry.getKey();
        String price = entry.getValue();
    %>
        <tr>
            <td><%= name1 %></td>
            <td><%= price %></td>

        </tr>
    <% } %>
    <tr>
        <td colspan=3>total=</td>
    </tr>
</table>
<form action="osOrderSuccess" method="post">
  <p><button type="submit" style="background-color:black;color:white;width:50px;height:35px;width:80px">Place Order</button></p></br>	
  </form>
	<form action="MyOrdersPageBackend" method="post">
  <p><button type="submit" style="background-color:green;color:white;width:50px;height:35px;width:80px">My Orders</button></p>
  </form>
  <a href="OsFrontPage.jsp" ><p><button style="background-color:#0096FF;color:white;width:100px;height:40px;width:50px">Home</button></p></a>
</body>
</html>