//package onlineShopping;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class osJdbcCnct extends osJdbc
//{
//	public static void main(String[] args) throws ClassNotFoundException,SQLException
//	{
//		try
//		{
//			Class.forName(osJdbc.Driver);
//			Connection con=DriverManager.getConnection(osJdbc.url, osJdbc.user, osJdbc.password);
//			Statement stmt =con.createStatement();
//			ResultSet rs=stmt.executeQuery();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//}
