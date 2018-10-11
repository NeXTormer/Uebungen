package objects;

import database.Database;

import javax.xml.crypto.Data;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Job {

    public static ArrayList<Integer> s_Categories;

    private Category m_Category;
    private int m_OrderID;
    private String m_Student;
    private String m_Class;
    private String m_Project;
    private String m_Comment;


    private Job(Category cat, int id, String student, String cl, String project, String comment)
    {
        m_Category = cat;
        m_OrderID = id;
        m_Student = student;
        m_Class = cl;
        m_Project = project;
        m_Comment = comment;

    }

    public static ArrayList<Job> loadJobsFromDB(Database db)
    {
        ArrayList<Job> jobs = new ArrayList<>();
        s_Categories = new ArrayList<>();

        ResultSet rs = db.Query("SELECT * FROM orders ORDER BY id ASC;");
        try
        {
            while(rs.next())
            {
                int id = rs.getInt(1);
                String student = rs.getString(2);
                int category = rs.getInt(3);
                String cl = rs.getString(4);
                String project = rs.getString(5);
                String comment = rs.getString(6);

                ResultSet crs = db.Query("SELECT name FROM category WHERE id = " + category + ";");
                crs.next();
                String catString = crs.getString(1);
                Category cat = new Category(category, catString);
                if(!s_Categories.contains(category)) s_Categories.add(category);
                Job j = new Job(cat, id, student, cl, project, comment);
                jobs.add(j);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return jobs;
    }

    public Category getCategory() {
        return m_Category;
    }

    public int getOrderID() {
        return m_OrderID;
    }

    public String getStudent() {
        return m_Student;
    }

    public String getStudentClass() {
        return m_Class;
    }

    public String getProject() {
        return m_Project;
    }

    public String getComment() {
        return m_Comment;
    }
}
