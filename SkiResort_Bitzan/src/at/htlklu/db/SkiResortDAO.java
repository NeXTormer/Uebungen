package at.htlklu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.htlklu.db.DBConnection;
import at.htlklu.obj.SkiResort;

public class SkiResortDAO 
{
	private static SkiResort mapRow(ResultSet r) throws SQLException
	{
		return new SkiResort(r.getInt("id"), r.getString("name"));
	}
	
	public static List<SkiResort> getSkiResorts() throws ClassNotFoundException, SQLException
	{
		List<SkiResort> skiresorts = new ArrayList<>();
		String sql = "select * from skiresort order by name";
		ResultSet r = DBConnection.executeQuery(sql);
		while(r.next())
		{
			skiresorts.add(mapRow(r));
		}
		
		return skiresorts;
	}
	
	public static synchronized void addSkiResort(SkiResort sr) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO `SkiResortMonitor`.`skiresort` (`name`) VALUES (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, sr.getName());

		pst.executeUpdate();
	}

}
