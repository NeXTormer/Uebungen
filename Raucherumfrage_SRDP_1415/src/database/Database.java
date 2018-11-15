package database;

import objects.Category;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Felix on 25/12/2017.
 */

/**
 * No longer in use as it has been replaced with the GameData-API
 */
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


    public Connection getConnection()
    {
        return m_Connection;
    }

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
            System.err.println("[Database] Could not connect to MySQL server.");
            e.printStackTrace();
            connectionEstablished = false;
            return;
        }
        System.out.println("[Database] Successfully connected to the database.");
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
    public static void PrintResultSet(ResultSet rs)
    {
        if(rs == null)
        {
            System.out.println("[Database] ResultSet does not exist.");
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

    public String getCategoriesHTML()
    {
        ArrayList<Category> categories = Category.loadCategories(this);

        StringBuilder sb = new StringBuilder(70);


        for(Category c : categories)
        {
            sb.append("<input type=\"radio\" name=\"behaviour\" value=\"");
            sb.append(c.getID());
            sb.append("\">");
            sb.append(c.getName());
            sb.append("<br>");
        }
        return sb.toString();
    }

    public String PrintResultSetHTMLNice(ResultSet rs)
    {
        String html = "<table>";
        if(rs == null)
        {
            System.out.println("[Database] ResultSet does not exist.");
            return "Error";
        }
        try
        {
            int colCount = rs.getMetaData().getColumnCount();

            html += "<tr>";
            for(int i = 0; i < colCount; i++)
            {
                html += "<th>";
                html += rs.getMetaData().getColumnName(i + 1);

                html += "</th>";
            }
            html += "</tr>";


            while(rs.next())
            {
                html +="<tr>";

                for(int i = 0; i < colCount; i++)
                {
                    html += "<td>";
                    html += rs.getString(i + 1) + (i == (colCount-1) ? "" : " </td><td> ");
                    html += "</td>";
                }
                html +="</tr>";
            }
            html +="</table>";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error";
        }




        return html;
    }

    public String PrintResultSetHTML(ResultSet rs)
    {
        String html = "<table>";
        if(rs == null)
        {
            System.out.println("[Database] ResultSet does not exist.");
            return "Error";
        }
        try
        {
            int colCount = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                html +="<tr>";
                for(int i = 0; i < colCount; i++)
                {
                    html += "<td>";
                    html += rs.getMetaData().getColumnName(i + 1) + ": " + rs.getString(i + 1) + (i == (colCount-1) ? "" : " </td><td> ");
                    html += "</td>";
                }
                html +="</tr>";
            }
            html +="</table>";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error";
        }

        return html;
    }


    /**
     * Returns the first value of the ResultSet. Useful for queries like (SELECT id FROM players WHERE name = "test";)
     * @param rs ResultSet to use.
     * @return First value of the ResultSet as String.
     */
    public String FirstValue(ResultSet rs)
    {
        if(rs == null) return "[Database] ResultSet does not exist.";
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

}
