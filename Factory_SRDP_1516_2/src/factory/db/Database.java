package factory.db;

import java.sql.*;

public class Database {
    private static final String DEFAULT_USER = "user";
    private static final String DEFAULT_PASSWORD = "PeterRendl69!";

    private static final String DEFAULT_SERVER = "faoiltiarna.ddns.net";
    private static final int DEFAULT_PORT = 3306;
    private static final String DEFAULT_SCHEMA = "htl_factory_2";

    private static Connection connection;

    public static synchronized Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = String.format("%s:%s/%s", DEFAULT_SERVER, DEFAULT_PORT, DEFAULT_SCHEMA);
                String fullURL = String.format("jdbc:mysql://%s?useSSL=false", url);
                connection = DriverManager.getConnection(fullURL, DEFAULT_USER, DEFAULT_PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return connection;
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet rset = statement.executeQuery(sql);
        return rset;
    }

    public static void close() {
        try {
            if (connection != null)
                connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
