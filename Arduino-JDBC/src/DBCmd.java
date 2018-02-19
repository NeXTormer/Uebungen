/*
 * DBCmd.java
 *
 * Created on 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author
 */
public class DBCmd {

    Driver mySqlDriver;                 // JDBC-Treiber
    Connection conn;                    // Connection zur DB
    Statement stm;                      // Sql-Befehl

    /** Verbindet mit der Datenbank */
    public DBCmd() {
        try {
            mySqlDriver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(mySqlDriver);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/messwerte", "root", "");
            stm = conn.createStatement();
            System.out.println("Conn created");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
    //
    // Einfügen von Daten
    //
    public void SQLStatement(String sql) {

        System.out.println(sql);
        try {
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // 
    // Ändern von Daten
    //
    //
    // Löschen der DB
    //
    //
    // Lesen aus der DB
    //
    public ResultSet getData(String sql) {
        ResultSet rset = null;
        try {
            rset = (ResultSet) stm.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rset;
    }
    // 
    // Ende der Verbindung
    //
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

