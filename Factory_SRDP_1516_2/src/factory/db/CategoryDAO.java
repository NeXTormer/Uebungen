package factory.db;

import factory.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO
{
    public static Category mapRow(ResultSet rs)
    {
        try
        {
            return new Category(rs.getInt(1), rs.getString(2));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return new Category(-1, "Error");
    }

    public static ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();
        try
        {
            ResultSet rs = Database.executeQuery("SELECT * FROM categories ORDER BY name;");
            while(rs.next())
            {
                categories.add(mapRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return categories;
    }

    public static Category getCategory(int id)
    {
        try
        {
            ResultSet rs = Database.executeQuery("SELECT * FROM categories WHERE id = " + id + ";");
            while(rs.next())
            {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return new Category(-1, "Error");
    }


}
