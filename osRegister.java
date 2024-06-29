package newOsShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/osRegister")
public class osRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
        {
			Class.forName(osJdbc.Driver);
            Connection con = DriverManager.getConnection(osJdbc.url, osJdbc.user, osJdbc.password);
              
            PreparedStatement st = con.prepareStatement("insert into onlineshopping values(?, ?, ?, ?)");

            st.setString(1, request.getParameter("name"));
            st.setString(2, request.getParameter("email"));
            st.setString(3, request.getParameter("password"));
            st.setString(4, request.getParameter("number"));

            PrintWriter out = response.getWriter();
            int record = st.executeUpdate(); //returns the int value
            if (record > 0)
            {
				out.print("Account Created Successfully");
			}
            else
            {
            	out.print("please enter valid details");
            }
            st.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }	
	}
}
