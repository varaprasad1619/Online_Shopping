package newOsShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
@WebServlet("/osLogin")
public class osLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
        {
			Class.forName(osJdbc.Driver);
            Connection con = DriverManager.getConnection(osJdbc.url, osJdbc.user, osJdbc.password);
            
            String query = "SELECT * FROM onlineshopping WHERE Email_id = '"+request.getParameter("email")+"' AND Password = '"+request.getParameter("password")+"'";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
           
                ResultSet resultSet = preparedStatement.executeQuery(query);                
                    if (resultSet.next()) 
                    {
                    	String a = resultSet.getString("Name");
                    	HttpSession session=request.getSession();  
                        session.setAttribute("Name",a);
                    	RequestDispatcher dispatcher = request.getRequestDispatcher("OsFrontPage.jsp"); 
                        dispatcher.include(request, response);
                    } 
                    else 
                    {
                        response.getWriter().println("Invalid email or password!");
                    }                
        }
		catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
