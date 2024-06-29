package newOsShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/osOrderSuccess")
public class osOrderSuccess extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql="INSERT INTO osproductsplaced SELECT * from osproducts";
		String sql2="TRUNCATE TABLE osproducts";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://10.5.0.24:3307/prasad", "root","finsol");
			Statement stmt =con.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			
		}
		catch (SQLException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/OrderPlacedSuccessfully.jsp");
		
	}
	

}
