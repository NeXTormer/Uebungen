package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Articles {

    private String title;
    private String author;
    private String subtitle;
    private String text;
    private String visibility;
    private Date timestamp;


    private Articles(String title_, String author_, String subtitle_, String text_, String visibility_, Date timestamp_)
    {
        timestamp = timestamp_;
        title = title_;
        subtitle = subtitle_;
        text = text_;
        visibility = visibility_;
        author = author_;

    }

    public static ArrayList<Articles> loadArticles(Database db) throws SQLException {
        ArrayList<Articles> a = new ArrayList<>();

        ResultSet rs = db.Query("SELECT * FROM articles ORDER BY timestamp DESC;");

        while(rs.next())
        {
            a.add(new Articles(rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(2).equals(1) ? "Oeffentlich" : "Intern", rs.getDate(7)));
        }

        return a;
    }

    public String toHTMLTableRow()
    {
        return "<tr><td>" + title + "</td><td>" + author + "</td><td>" + timestamp.toString() + "</td><td>" + visibility + "</td></tr>";
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getVisibility() {
        return visibility;
    }
}
