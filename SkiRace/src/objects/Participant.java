package objects;

import company.database.Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public static String getHTMLTable(ArrayList<Participant> participants)
    {
        //Stringbuilder
        String table = "";

        int maxtimes = 0;
        Participant maxtimesp = null;
        for(Participant p : participants)
        {
            if(maxtimes < p.getTimes().size())
            {
                maxtimes = p.getTimes().size();
                maxtimesp = p;
            }
        }

        ArrayList<String> timecats = new ArrayList<>();
        //Collections.sort(maxtimesp.getTimes(), sortTimesAlphabetical);

        for(Time t : maxtimesp.getTimes())
        {
            timecats.add(t.getCategory());
        }

        Collections.sort(timecats);

        for (int i = 0; i < timecats.size(); i++)
        {
            if(timecats.get(i).equalsIgnoreCase("ZF"))
            {
                timecats.remove(i);
                timecats.add("ZF");
            }
        }

        table += "<table border=\"1\"> <tr> <th>SNR</th><th>Name</th><th>Kat.</th>";

        for(String s : timecats)
        {
            table += "<th>" + s + "</th>";
        }

        table += "</tr>";

        for(Participant p : participants)
        {
            table += "<tr><td>" + p.getID() + "</td><td>" + p.getName() + " " + p.getSurname() + "</td><td>" + p.getCategory().getShortName() + "</td>";
            Collections.sort(p.getTimes(), sortTimesAlphabetical);

            ArrayList<String> tcat = new ArrayList<>();
            for(Time t : p.getTimes())
            {
                boolean found = false;
                for(String s : timecats)
                {
                    if(t.getCategory().equalsIgnoreCase(s)) {
                        found = true;
                    }
                }
                if(found)
                {
                    table += "<td>" + t.getTimeString() + "</td>";
                }
                else
                {
                    table += "<td> - </td>";
                }
            }
            table += "</tr>";

        }
        return table;
    }

    public int getID()
    {
        return m_ID;
    }

    public String getName()
    {
        return m_Name;
    }

    public String getSurname()
    {
        return m_Surname;
    }

    public String getDOB()
    {
        return m_DOB;
    }

    public Category getCategory()
    {
        return m_Category;
    }

    private static Comparator<Time> sortTimesAlphabetical = new Comparator<Time>() {
        @Override
        public int compare(Time o1, Time o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.getCategory(), o2.getCategory());
        }
    };

    public String getHTMLTableRow()
    {
        String tr = "<tr><td>" + m_ID + "</td><td>" + m_Name + " " + m_Surname + "</td><td>" + m_Category.getShortName() ;
        return "werner";
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