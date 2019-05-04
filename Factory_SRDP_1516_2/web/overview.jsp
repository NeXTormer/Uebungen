<%@ page import="factory.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="factory.db.CategoryDAO" %>
<%@ page import="factory.Job" %>
<%@ page import="factory.db.JobDAO" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/05/2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order overview</title>
</head>
<body>

<h1>Order Overview</h1>
<%
    ArrayList<Category> categories = CategoryDAO.getAllCategories();

    for(Category category : categories)
    {
        ArrayList<Job> jobs = JobDAO.getAllJobs(category);
        if(jobs.size() > 0)
        {
            out.println("<fieldset>");
            out.println("<h2>" + category.getName() + "</h2>");
            out.println("<table>");
            out.println("<tr><th>Order No</th><th>Student/Team</th><th>Class</th><th>Project</th><th>Comment</th><th></th></tr>");
            for(Job j : jobs)
            {
                out.println(j.toHTMLTableRow());
            }
            out.println("</table>");
            out.println("</fieldset>");
        }

    }
%>
<br>
<a href="index.jsp">back to order page</a>
</body>
</html>
