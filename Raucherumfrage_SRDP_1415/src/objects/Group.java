package objects;

import database.Database;

import javax.sql.rowset.serial.SerialRef;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group {

    private int m_Lowerlimit;
    private int m_Upperlimit;

    public String m_Name;

    public ArrayList<CategoryEntry> m_Entries;

    public Group(int upper, int lower, Database db) {
        m_Upperlimit = upper;
        m_Lowerlimit = lower;

        m_Name = (m_Lowerlimit == 0 ? "< " + m_Upperlimit + " Jahre" : (m_Upperlimit == 0 ? "> " + m_Lowerlimit + "Jahre" : m_Lowerlimit + " - " + m_Upperlimit + " Jahre"));

        m_Entries = new ArrayList<>();

        try
        {

            ResultSet rsgas = db.Query("SELECT count(*) FROM category;");
            rsgas.next();
            int count = rsgas.getInt(1);
            for(int i = 1; i <= count; i++)
            {
                System.out.println("WERNER" + i);
                m_Entries.add(new CategoryEntry(i, this, db));
                System.out.println("NEW CAT ENT");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public int getUpperLimit()
    {
        return m_Upperlimit;
    }

    public int getLowerLimit()
    {
        return m_Lowerlimit;
    }

}
