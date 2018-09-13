package at.htlklu.fsst;
import java.sql.*;

public class Database 
{
	
	private Connection m_Connection;
	
	
	public Database(String host, String db, String user, String password)
	{
		Driver jdbcdriver;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			m_Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		    
	}
	
	public ResultSet query(String query)
	{
		ResultSet rs;
		try 
		{
			Statement statement = m_Connection.createStatement();
			rs = statement.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(String query, String... values)
	{
		try 
		{
			PreparedStatement pstatement = m_Connection.prepareStatement(query);
			for(int i = 0; i < values.length; i++)
			{
				pstatement.setString(i+1, values[i]);
			}
			
			pstatement.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
