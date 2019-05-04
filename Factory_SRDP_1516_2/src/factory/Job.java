package factory;

public class Job
{
    private Category category;
    private int orderID;
    private String student;
    private String studenclass;
    private String project;
    private String comment;


    public Job(Category category, int orderID, String student, String studenclass, String project, String comment)
    {
        this.category = category;
        this.orderID = orderID;
        this.student = student;
        this.studenclass = studenclass;
        this.project = project;
        this.comment = comment;
    }

    public Category getCategory()
    {
        return category;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public String getStudent()
    {
        return student;
    }

    public String getStudenclass()
    {
        return studenclass;
    }

    public String getProject()
    {
        return project;
    }

    public String getComment()
    {
        return comment;
    }

    public String toHTMLTableRow()
    {
        StringBuilder sb = new StringBuilder(100);
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(this.orderID);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(this.student);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(this.studenclass);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(this.project);
        sb.append("</td>");
        sb.append("<td>");
        sb.append(this.comment);
        sb.append("</td>");
        sb.append("<td>");
        sb.append("<a href=\"delete.jsp?id=" + this.orderID + "\">Delete</a>");
        sb.append("</td>");

        return sb.toString();
    }
}
