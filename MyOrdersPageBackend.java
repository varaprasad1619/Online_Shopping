package newOsShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyOrdersPageBackend")

public class MyOrdersPageBackend extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql="SELECT * from osproductsplaced";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://10.5.0.24:3307/prasad", "root","finsol");
			Statement stmt =con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			Map<String, String> hm = new HashMap<String, String>();
			while (rs.next()) 
			{
				String productName=rs.getString("productName");
				String price=rs.getString("price");
    			hm.put(productName, price);
			}
			request.setAttribute("hm", hm);
			request.getRequestDispatcher("/MyOrdersPage.jsp").forward(request, response);
		} 
		catch (SQLException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}


