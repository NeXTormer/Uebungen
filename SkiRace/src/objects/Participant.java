package objects;

import company.database.Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Participant implements Comparable<Participant> {

    private int m_ID;
    private String m_Name;
    private String m_Surname;
    private String m_DOB;
    private Category m_Category;

    private ArrayList<Time> m_Times;

    public Participant() {}

    private Participant(int id, String name, String surname, String dob, Category category, ArrayList<Time> times)
    {
        m_ID = id;
        m_Name = name;
        m_Surname = surname;
        m_DOB = dob;
        m_Category = category;
        m_Times = times;
    }

    public static ArrayList<Participant> loadParticipants(Connection databaseconnection)
    {
        ArrayList<Participant> participants = new ArrayList<>();

        PreparedStatement statement;
        ResultSet result;

        try {
            statement = databaseconnection.prepareStatement(Statements.SQL_GET_PARTIPANTS);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String dob = rs.getString(4);
                int cat = rs.getInt(5);
                Category category = new Category();
                category.loadCategory(cat, databaseconnection);
                ArrayList<Time> times = Time.loadTimes(id, databaseconnection);

                participants.add(new Participant(id, name, surname, dob, category, times));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return participants;
    }

    public ArrayList<Time> getTimes()
    {
        return m_Times;
    }
    public String toString()
    {
        String times = "";
        for(Time t : m_Times)
        {
            times += t.toString() + " ";
        }

        return "Participant: " + m_Name + ", " + m_Surname + ", " + m_DOB + ", " + m_Category.toString() + " | " + times;
    }

    @Override
    public int compareTo(Participant o) {
        double endself = 0;
        double endother = 0;

        for(Time t : m_Times)
        {
            if(t.getCategory().equals("ZF"))
            {
                endself = t.getTime();
            }
        }
        for(Time t : o.getTimes())
        {
            if(t.getCategory().equals("ZF"))
            {
                endother = t.getTime();
            }
        }

        return (int) ((endself - endother) * 1000);
    }
}