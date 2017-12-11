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
		Driver mySqlDriver; // JDBC-Treiber
		Connection conn;
		Statement upd;

		System.out.println("Starting...");

		try {
			// JDBC-Treiber laden
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.toString());
			System.exit(1);
		}

		try {
			// Verbindung herstellen
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			// Neues Statement erzeugen, wird mehrfach verwendet
			upd = conn.createStatement();

			// Tabelle anlegen
			int res = upd.executeUpdate("create table test01(col1 int primary key,col2 char(20))");
			System.out.println("RetCode von <create table>: " + res);

			// Daten in die Tabelle schreiben
			res = upd.executeUpdate("insert into test01 values(1,'hallo')");
			System.out.println("RetCode von <insert>: " + res);
			res = upd.executeUpdate("insert into test01 values(2,'12345678901234567890')");
			System.out.println("RetCode von <insert>: " + res);

			// Daten aus der Tabelle lesen
			ResultSet rset = upd.executeQuery("select * from test01");
			while (rset.next() == true) {
				System.out.println("col1: " + rset.getInt("col1") + " col2: " + rset.getString("col2"));
			}

			// Tabelle wieder l�schen
			res = upd.executeUpdate("drop table test01");
			System.out.println("RetCode von <drop table>: " + res);
		} catch (SQLException e) {
			System.out.print("getConnection(): ");
			System.out.println(e.toString());
			System.exit(1);
		}

		System.out.println("Bye!");
	}
}