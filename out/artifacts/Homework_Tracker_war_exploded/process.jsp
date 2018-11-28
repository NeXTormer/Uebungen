<%@ page import="at.htlklu.holz.DBConnector" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 28/11/2018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing</title>
</head>
<body>

<%
    String description = request.getParameter("description");
    String subject = request.getParameter("subject");
    String duedate = request.getParameter("duedate");

    DBConnector db = DBConnector.getInstance();

    try {
        db.update("INSERT INTO tasks (task, subject, duedate) VALUES (?, ?, ?);", description, subject, duedate);
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("Database Error");
    }
%>



<meta http-equiv="refresh" content="0; url=list.jsp">

</body>
</html>
