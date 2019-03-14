package at.htlklu.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBConnection 
{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/skiresortmonitor";
	private static final String DB_USER = "root";
	private static final String DB_PW = "";
	
	private static Connection conn = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(conn==null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		}
		return conn;
	}
	
	public static synchronized ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException
	{
		Statement stm = DBConnection.getConnection().createStatement();
		return stm.executeQuery(sql);
	}

}
