<%@ page import="at.htlklu.holz.DBConnector" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="at.htlklu.holz.Task" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 28/11/2018
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>

<h1>Track your homework with HTL Moessingerstrasse</h1>
<h2>Pending tasks:</h2>

<%
    DBConnector db = DBConnector.getInstance();

    out.println("<table>");
    ArrayList<Task> tasks = Task.loadTasks();

    for(Task t : tasks)
    {
        out.println(t.toHTMLTableRow());
    }

    out.println("</table>");
%>

</body>
</html>
