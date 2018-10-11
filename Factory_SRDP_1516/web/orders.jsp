<%@ page import="objects.Job" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.Database" %>
<%@ page import="objects.Category" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="objects.JobGroup" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 11/10/2018
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Overview</title>

    <style>
        fieldset
        {
            background-color: #FFFFCC;
        }
    </style>


</head>
<body>
<h1>Order Overview</h1>

<%
    Database db = new Database("faoiltiarna.ddns.net", "htl_factory", "user", "PeterRendl69!");

    ArrayList<Job> jobs = Job.loadJobsFromDB(db);

    for(int i : Job.s_Categories)
    {
        ResultSet crs = db.Query("SELECT name FROM category WHERE id = " + i + ";");
        crs.next();
        String catString = crs.getString(1);
        Category cat = new Category(i, catString);
        JobGroup jg = new JobGroup(cat, jobs);
        out.println(jg.toHTML());
    }


%>

<br>
<a href="index.jsp">Back to order page</a>

</body>
</html>

