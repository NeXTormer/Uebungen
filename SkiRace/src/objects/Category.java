package objects;

import company.database.Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static company.database.Database.PrintResultSet;

public class Category {

    private String m_Short;
    private String m_Long;

    public Category() {}

    public void loadCategory(int catid, Connection databaseconnection)
    {
        PreparedStatement statement;
        ResultSet result;

        try {
            statement = databaseconnection.prepareStatement(Statements.SQL_GET_CATEGORY_FROM_ID);
            statement.setInt(1, catid);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                m_Long = rs.getString(2);
                m_Short = rs.getString(3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getShortName()
    {
        return m_Short;
    }

    public String toString()
    {
        return m_Long + " (" + m_Short + ")";
    }

}
