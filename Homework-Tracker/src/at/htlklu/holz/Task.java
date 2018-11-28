package at.htlklu.holz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task {

    private String description;
    private String subject;
    private Date duedate;

    public Task(String desc, String subj, Date date)
    {
        description = desc;
        subject = subj;
        duedate = date;
    }

    public String toHTMLTableRow()
    {
        SimpleDateFormat format = new SimpleDateFormat("H:m:s y-M-D");
        StringBuilder sb = new StringBuilder(200);
        sb.append("<tr><td>");
        sb.append(format.format(duedate));
        sb.append("</td><td>");
        sb.append(description);
        sb.append("</td><td>");
        sb.append(subject);
        sb.append("</td></tr>");

        return sb.toString();
    }

    public static ArrayList<Task> loadTasks() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();

        ResultSet rs = DBConnector.getInstance().query("SELECT * FROM tasks ORDER BY duedate DESC;");
        while(rs.next())
        {
            tasks.add(new Task(rs.getString("task"), rs.getString("subject"), rs.getDate("duedate")));
        }
        return tasks;
    }

    public String getDescription() {
        return description;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDuedate() {
        return duedate;
    }
}
