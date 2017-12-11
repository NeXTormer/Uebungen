import java.util.*;
import java.sql.*;

/**
 * <b>Einfaches Beispiel fuer ein JDBC-Programm</b>
 * </p>
 *
 * <p>
 * Im Beispiel wird eine Verbindung zur Test-Datenbank aufgebaut. Eine Tabelle
 * wird erzeugt und mit Werten beschrieben. Diese Werte werden anschlieszend
 * wieder ausgelesen, die Tabelle wird geloescht.
 * </p>
 *
 * <p>
 * Bevor das Programm gestartet werden kann, muss der MySql-Server gestartet
 * werden.
 * </p>
 *
 */
public class JDBCMain 
{
	public static void main(String[] args) 
	{
		Driver mySqlDriver;
		Connection conn;
		Statement upd;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e1) 
		{
			System.out.println(e1);
			System.exit(1);
		}

		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/htl_waytoschool", "root", "");
			upd = conn.createStatement();

			int res = upd.executeUpdate("use htl_waytoschool");
		
			ResultSet rset = upd.executeQuery("select v.name, productionyear, distance as 'Distance [km]', s.name as Owner from vehicle v, student s where productionyear < 2001  and s.id = v.student_id order by productionyear desc;\r\n");
			while (rset.next()) 
			{
				System.out.println("Name: " + rset.getString(1) + ", Productionyear: " + rset.getInt(2) + ", Distance [km]: " + rset.getInt(3) + ", Owner: " + rset.getString(4));
			}

			conn.close();

		} 
		catch (SQLException e) 
		{
			System.out.print("MYSQL Connection error: ");
			System.out.println(e);
			System.exit(1);
		}
		

	}
}