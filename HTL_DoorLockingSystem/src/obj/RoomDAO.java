package obj;

import java.io.IOException;
import java.sql.PreparedStatement;
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

    public static boolean update(Room room)
    {
        try
        {
            PreparedStatement s = Database.getConnection().prepareStatement("UPDATE rooms SET locked = ? WHERE id = ?;");
            s.setBoolean(1, room.isLocked());
            s.setInt(2, room.getId());

            s.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static Room getRoom(String name)
    {
        try
        {
            ResultSet rs = Database.executeQuery("SELECT * FROM rooms WHERE name = \"" + name + "\";");
            Room room = null;
            while(rs.next())
            {
                room = RoomDAO.mapRow(rs);
            }

            return room;

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
