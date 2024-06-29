public class Product {
    private String productName;
    private String price;
 
    public Product(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }
 
    // Add getters and setters as needed
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public String getPrice() {
        return price;
    }
 
    public void setPrice(String price) {
        this.price = price;
    }
}


safe code

Map hm = (Map)request.getAttribute("hm");
for (Map.Entry<String, String> set : hm.entrySet()) 
{
   System.out.println(set.getKey() + " = " + set.getValue() );
}
------------------------------------------------------
<!-- <% 
Map hm = (Map)request.getAttribute("hm");
for (String pn : hm.keySet())   //using keyset() method for iteration over keySet  
	System.out.println("State: " + pn);   
	for (String pr : hm.values())         //using values() for iteration over keys  
	System.out.println("Capiatl: " + pr);
%> -->
<!-- <%
Map hm = (Map)request.getAttribute("hm");
for (Map.Entry<String, Integer> entry : hm.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
%> -->
--------------------------------------------------
<%
Map hm = (Map)request.getAttribute("hm");//working code
System.out.println(hm);
%>
=------------------------------------
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
 
<%
    Map<String, String> pname = (Map<String, String>) request.getAttribute("hm");
    Iterator<Map.Entry<String, String>> iterator = pname.entrySet().iterator();
%>
 
<table border="1">
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