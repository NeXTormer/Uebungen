package at.htlklu.holz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskDAO {

    public static Task mapRow(ResultSet rs) throws SQLException
    {
        return new Task(rs.getString(1), rs.getString(2), rs.getDate(3));
    }


}
