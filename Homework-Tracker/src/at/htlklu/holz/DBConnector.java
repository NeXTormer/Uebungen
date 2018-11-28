package at.htlklu.holz;

import java.sql.*;

public class DBConnector {

    private static DBConnector instance;
    private Connection connection;

    public static DBConnector getInstance()
    {
        if(instance == null)
        {
            try {
                instance = new DBConnector();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void closeConnection() throws SQLException
    {
        connection.close();
    }

    public ResultSet query(String query, String... items) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        for(int i = 1; i <= items.length; i++)
        {
            ps.setString(i, items[i-1]);
        }

        return ps.executeQuery();
    }

    public void update(String query, String... items) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        for(int i = 1; i <= items.length; i++)
        {
            ps.setString(i, items[i-1]);
        }
        ps.executeUpdate();
    }


    private DBConnector() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://10.0.0.254:3306/htl_homeworktracker", "user", "PeterRendl69!");

    }


}
