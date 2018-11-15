package objects;

import com.sun.org.apache.xpath.internal.SourceTree;
import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryEntry {

    public int m_ID;
    public int m_M;
    public int m_F;
    public int m_Total;

    private Database m_db;

    public CategoryEntry(int catid, Group group, Database db)
    {
        m_db = db;
        try {

            ResultSet rs1 = m_db.Query("SELECT count(*) FROM participant WHERE category = " + catid + " AND age < " + group.getUpperLimit() + " AND age > " + group.getLowerLimit() + " AND gender = 'M';");
            rs1.next();
            ResultSet rs2 = m_db.Query("SELECT count(*) FROM participant WHERE category = " + catid + " AND age < " + group.getUpperLimit() + " AND age > " + group.getLowerLimit() + " AND gender = 'F';");
            rs2.next();
            m_M = rs1.getInt(1);
            m_F = rs2.getInt(1);
            System.out.println(m_F);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        m_Total = m_F + m_M;

    }



}
