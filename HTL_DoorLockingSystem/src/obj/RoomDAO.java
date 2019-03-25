package obj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO
{
    public static List<Room> getAllRooms(String visibility)
    {
        String query = "";
        List<Room> rooms = new ArrayList<>();

        if(visibility.equals("locked"))
        {
            query = "SELECT * FROM rooms WHERE locked = true;";
        }
        else if(visibility.equals("unlocked"))
        {
            query = "SELECT * FROM rooms WHERE locked = false;";
        }
        else
        {
            query = "SELECT * FROM rooms;";
        }

        try
        {
            ResultSet rs = Database.executeQuery(query);

            while(rs.next())
            {
                rooms.add(mapRow(rs));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return rooms;
    }

    public static Room mapRow(ResultSet rs)
    {
        try
        {
            return new Room(rs.getInt("id"), rs.getString("name"), rs.getBoolean("locked"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }


}
