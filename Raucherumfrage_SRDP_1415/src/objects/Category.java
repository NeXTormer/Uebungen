package objects;

import database.Database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category
{

    private String m_ShortName;
    private String m_Name;
    private int m_ID;


    private Category(int id, String name, String shortname)
    {
        m_ShortName = shortname;
        m_ID = id;
        m_Name = name;
        System.out.println("ID: " + id + ", Name; " + name);
    }

    public static ArrayList<Category> loadCategories(Database db)
    {
        ArrayList<Category> categories = new ArrayList<>();


        try {
            ResultSet rs = db.Query("SELECT * FROM category;");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String nameshort = rs.getString(3);

                categories.add(new Category(id, name, nameshort));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return categories;
    }

    public String getName()
    {
        return m_Name;
    }

    public String getShortName()
    {
        return m_ShortName;
    }

    public int getID()
    {
        return m_ID;
    }
}
