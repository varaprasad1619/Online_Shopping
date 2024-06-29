package newOsShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/AddToCartServlet")

public class AddToCartServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        HttpSession session = request.getSession();

        String productName = request.getParameter("productName");
        String price = request.getParameter("price");

        Map<String, String> cart = (Map<String, String>) session.getAttribute("cart");
        if (cart == null) 
        {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        cart.put(productName, price);
        
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.5.0.24:3307/prasad", "root","finsol");
            String insertquery="insert into osproducts(productName,price) values (?,?)";
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(insertquery);
            ps.setString(1, productName);
            ps.setString(2, price);
            ps.executeUpdate();
            con.close();            		
        }
        catch(ClassNotFoundException | SQLException e)
        {
        	e.printStackTrace();      	
        }
        response.sendRedirect(request.getContextPath() + "/OsFrontPage.jsp");        
    }
}