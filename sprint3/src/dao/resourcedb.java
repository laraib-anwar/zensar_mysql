package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourceDB
{
	public static Connection con;
	public static Connection getDbConnection() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","2Rucha16");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
}
