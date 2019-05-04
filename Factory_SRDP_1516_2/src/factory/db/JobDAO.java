package factory.db;

import factory.Category;
import factory.Job;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JobDAO
{

    private static PreparedStatement preparedInsertStatement;
    private static PreparedStatement preparedDeleteStatement;
    static
    {
        try
        {
            preparedInsertStatement = Database.getConnection().prepareStatement("INSERT INTO jobs (student, studentclass, project, comment, category) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            preparedDeleteStatement = Database.getConnection().prepareStatement("DELETE FROM jobs WHERE id= ?;");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Job mapRow(ResultSet rs)
    {
        try
        {
            int cat = rs.getInt("category");
            Category category = CategoryDAO.getCategory(cat);

            return new Job(category, rs.getInt("id"), rs.getString("student"), rs.getString("studentclass"), rs.getString("project"), rs.getString("comment"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Job> getAllJobs()
    {
        ArrayList<Job> jobs = new ArrayList<>();
        try
        {
            ResultSet rs = Database.executeQuery("SELECT * FROM jobs ORDER BY id;");
            while(rs.next())
            {
                jobs.add(mapRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobs(Category category)
    {
        ArrayList<Job> jobs = new ArrayList<>();
        try
        {
            ResultSet rs = Database.executeQuery("SELECT * FROM jobs WHERE category = " + category.getId() + " ORDER BY id;");
            while(rs.next())
            {
                jobs.add(mapRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return jobs;
    }

    public static int insert(Job job)
    {
        try
        {
            preparedInsertStatement.setString(1, job.getStudent());
            preparedInsertStatement.setString(2, job.getStudenclass());
            preparedInsertStatement.setString(3, job.getProject());
            preparedInsertStatement.setString(4, job.getComment());
            preparedInsertStatement.setInt(5, job.getCategory().getId());

            preparedInsertStatement.executeUpdate();
            ResultSet rs = preparedInsertStatement.getGeneratedKeys();
            if(rs.next())
            {
                return rs.getInt(1);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public static void delete(int jobid)
    {
        try
        {
            preparedDeleteStatement.setInt(1, jobid);
            preparedDeleteStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
