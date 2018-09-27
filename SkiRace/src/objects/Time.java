package objects;

import company.database.Database;
import company.database.Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Time
{
    private int m_ID;
    private double m_Time;
    private String m_Category;

    private Time(int id, double time, String cat)
    {
        m_ID = id;
        m_Time = time;
        m_Category = cat;
    }

    public static ArrayList<Time> loadTimes(int participantid, Connection databaseconnection)
    {
        PreparedStatement statement;
        ResultSet result;

        ArrayList<Time> times = new ArrayList<>();

        try {
            statement = databaseconnection.prepareStatement(Statements.SQL_GET_TIMES_FROM_PARTICIPANT);
            statement.setInt(1, participantid);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt(1);
                double time = rs.getDouble(2);
                String cat = rs.getString(4);

                times.add(new Time(id, time, cat));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return times;
    }

    public int getID() {
        return m_ID;
    }

    public String getCategory()
    {
        return m_Category;
    }

    //TODO: Format peta
    public double getTime() {
        return m_Time;
    }

    public String toString()
    {
        return m_Category + ": " + getTime();
    }


}
