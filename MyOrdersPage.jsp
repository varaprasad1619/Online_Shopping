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
<title>My Orders Page</title>
</head>
<body align="center">
<%
	String name = (String) session.getAttribute("Name");
	out.print("Hi " +name+ ",Your Ordered Products Will be Displayed Here");
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
</table>
<a href="OsFrontPage.jsp" ><p><button style="background-color:#0096FF;color:white;width:100px;height:40px;width:100px">Back to Home</button></p></a>
</body>
</html>