package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database
{
    private Driver m_Driver;
    private Connection m_Connection;

    private String m_Database;
    private String m_Host;
    private String m_User;
    private String m_Password;

    private int m_GameID;

    public boolean connectionEstablished = false;

    /**
     * Creates a database objects and connects using MySQL.
     * @param host Hostname and port of the server separated by ':' in a single string.
     * @param database Name of the database.
     * @param user Username on the server.
     * @param password Password of the user.
     */
    public Database(String host, String database, String user, String password)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Could not load JDBC Driver!");
            connectionEstablished = false;
            return;
        }

        m_Host = host;
        m_Database = database;
        m_User = user;
        m_Password = password;

        Connect();
    }

    private void Connect()
    {
        try
        {
            m_Connection = DriverManager.getConnection("jdbc:mysql://" + m_Host + "/" + m_Database, m_User, m_Password);
        }
        catch(Exception e)
        {
            System.err.println("[company.database.Database] Could not connect to MySQL server.");
            e.printStackTrace();
            connectionEstablished = false;
            return;
        }
        System.out.println("[company.database.Database] Successfully connected to the database.");
        connectionEstablished = true;
    }

    /**
     * Executes a query (e.g. SELECT) on the server and returns the ResultSet.
     * @param query Query to execute.
     * @return Result of the operation.
     */
    public ResultSet Query(String query)
    {
        ResultSet result;
        try
        {
            Statement statement = m_Connection.createStatement();
            result = statement.executeQuery(query);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /**
     * Executes an update query (e.g. INSERT, UPDATE) on the server and returns the generated primary key.
     * @param query Query to execute.
     * @param items Values of the wildcards used in the query
     *              (e.g. (INSERT INTO playlist (title, artist, url) VALUES (?, ?, ?)) contains 3 wildcards instead of the values. The values passed
     *              into this function are replaced with the wildcards in the query).
     * @return Generated Primary Key.
     */
    public int Update(String query, String... items)
    {
        PreparedStatement statement;
        ResultSet result;
        int key = -1;

        try
        {
            statement = m_Connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            if(items.length != 0)
            {
                for(int i = 0; i < items.length; i++)
                {
                    statement.setString(i + 1, items[i]);
                }
            }

            statement.executeUpdate();
            result = statement.getGeneratedKeys();

            if(result.next())
            {
                key = result.getInt(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }

        return key;
    }

    /**
     * Prints the data from a ResultSet to the console.
     * @param rs ResultSet.
     */
    public void PrintResultSet(ResultSet rs)
    {
        if(rs == null)
        {
            System.out.println("[company.database.Database] ResultSet does not exist.");
            return;
        }
        try
        {
            int colCount = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                for(int i = 0; i < colCount; i++)
                {
                    System.out.print(rs.getMetaData().getColumnName(i + 1) + ": " + rs.getString(i + 1) + (i == (colCount-1) ? "" : " | "));
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
    }


    /**
     * Returns the first value of the ResultSet. Useful for queries like (SELECT id FROM players WHERE name = "test";)
     * @param rs ResultSet to use.
     * @return First value of the ResultSet as String.
     */
    public String FirstValue(ResultSet rs)
    {
        if(rs == null) return "[company.database.Database] ResultSet does not exist.";
        String result = "";
        try
        {
            if(rs.next())
            {
                result = rs.getString(1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "ERROR";
        }
        return result;
    }

    public void CloseConnection()
    {
        try {
            m_Connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Could not close MySQL connection.");
        }
    }
    
    
    public void lastMeasurements()
    {

    	String query = "SELECT room, DATE_FORMAT(time, '%H:%i:%s') as time, value, unit FROM measurements ORDER BY time DESC LIMIT 4;";
    	
    	ResultSet rs = Query(query);

        int colCount = 0;
        try {
            colCount = rs.getMetaData().getColumnCount();

            String[] titles = new String[colCount];
            ArrayList<String[]> data = new ArrayList<String[]>();

            while(rs.next())
            {
                String[] temp = new String[colCount];
                for(int i = 0; i < colCount; i++)
                {
                    titles[i] = rs.getMetaData().getColumnName(i + 1);
                    temp[i] = rs.getString(i + 1);
                }
                data.add(temp);
            }

            String dataformat = "|%-12s|%-12s|%11s|%12s|\n";
            
            System.out.println("+--Last-4-Entries----------------------------------+");
            System.out.println("|----Room----|----Time----|---Value---|----Unit----|");
            for(int i = 0; i < data.size(); i++)
            {
            	String[] stoff = data.get(i);
            	System.out.format(dataformat, stoff[0], stoff[1], stoff[2], stoff[3]);
            }
            System.out.println("+--------------------------------------------------+");
            System.out.println("");

        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
}
