import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class QuizManager {

	private Connection m_Connection;
	
	public QuizManager()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			m_Connection = DriverManager.getConnection("jdbc:mysql://pc219.el.htl.local:3306/htl_musicquiz","musicquiz","musicquiz");	
			System.out.println("Connection established.");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public int AddTeam(String teamname) throws SQLException
	{
		String query = "INSERT INTO teams (name) VALUES (?);";
		PreparedStatement statement;
		try 
		{
			statement = m_Connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, teamname);
			
			statement.executeUpdate(); //update because we want to change data
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next())
				return rs.getInt(1);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SQLException();
		}
		return -1;
	}
	
	public void AddSong(String title, String artist, String url) throws MalformedURLException
	{
		String query = "INSERT INTO playlist (title, interpret, url) VALUES (?, ?, ?);";
		PreparedStatement statement;
		try 
		{
			statement = m_Connection.prepareStatement(query);
			statement.setString(1, title);
			statement.setString(2, artist);
			statement.setString(3, new URL(url).toString());
			
			statement.executeUpdate(); //update because we want to change data
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<Song> GetSongs()
	{
		List<Song> songs = new ArrayList<Song>();
		
		try 
		{
			Statement statement = m_Connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM playlist");
			try 
			{
				while(rs.next())
					songs.add(new Song(rs.getString("title"), rs.getString("interpret"), rs.getString("url"), rs.getInt("id")));
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return songs;
	}
	
	public void Vote(String vote, int teamid, int songid)
	{
		
	}

}