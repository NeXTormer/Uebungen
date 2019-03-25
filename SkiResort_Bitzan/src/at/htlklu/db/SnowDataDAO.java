package at.htlklu.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.htlklu.db.DBConnection;
import at.htlklu.obj.SkiResort;
import at.htlklu.obj.SnowData;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.Date;


public class SnowDataDAO
{
	private static SnowData mapRow(ResultSet r) throws SQLException
	{
		return new SnowData(r.getInt("id"),r.getInt("skiresort_id"), r.getInt("depth"), r.getDate("lcldate").toLocalDate());
	}
	
	public static SnowData getSnowData(int skiresortid) throws ClassNotFoundException, SQLException
	{
		SnowData snowdata;
		String sql = "select * from snowdata where skiresort_id="+skiresortid+" order by lcldate desc limit 1";
		ResultSet r = DBConnection.executeQuery(sql);
		while(r.next())
		{
			snowdata = mapRow(r);			
			return snowdata;
		}
		return null;
		
	}
	
	public static synchronized void addSnowData(SnowData sd) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO `SkiResortMonitor`.`snowdata` (`skiresort_id`, `depth`, `lcldate`) VALUES (?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, sd.getSkiResortId());
		pst.setInt(2, sd.getDepth());
		LocalDate locald = LocalDate.of(sd.getDate().getYear(), sd.getDate().getMonthValue(), sd.getDate().getDayOfMonth());
		Date date = Date.valueOf(locald);
		pst.setDate(3, date);
		//pst.setDate(3, (java.sql.Date) Date.from(sd.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));;
		pst.executeUpdate();
	}

}
