package objects;

import java.util.ArrayList;

public class JobGroup {

    private Category m_Category;
    private ArrayList<Job> m_Jobs;

    public JobGroup(Category cat, ArrayList<Job> jobs)
    {
        m_Jobs = new ArrayList<>();
        m_Category = cat;
        for(Job j : jobs)
        {
            if(j.getCategory().getID() == cat.getID())
            {
                m_Jobs.add(j);
            }
        }
    }

    public String toHTML()
    {
        StringBuilder sb = new StringBuilder(400);

        sb.append("<fieldset>");
        sb.append("<h2>");
        sb.append(m_Category.getName());
        sb.append("</h2><br>");

        sb.append("<table cellpadding = \"4\">");
        sb.append("<tr><th>Order No.</th><th>Student/Team</th><th>Class</th><th>Project</th><th>Comment</th><th>&nbsp;</th></tr>");
        for(Job j : m_Jobs)
        {
            sb.append("<tr>");
            sb.append("<td>");
            sb.append(j.getOrderID());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(j.getStudent());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(j.getStudentClass());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(j.getProject());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(j.getComment());
            sb.append("</td>");
            sb.append("<td>");
            sb.append("<a href=\"delete.jsp?id=" + j.getOrderID() + "\">Delete</a>");
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</fieldset>");
        sb.append("<br>");
        return sb.toString();
    }
}
