<%@ page import="factory.Job" %>
<%@ page import="factory.db.CategoryDAO" %>
<%@ page import="factory.db.JobDAO" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/05/2019
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order confirmation</title>
</head>
<body>
    <fieldset>
        <h1>Thank you for your order.</h1>
        <h2>Your order number is <%
           String category = request.getParameter("category");
           String student = request.getParameter("student");
           String studentclass = request.getParameter("class");
           String project = request.getParameter("project");
           String comment = request.getParameter("comment");

           Job job = new Job(CategoryDAO.getCategory(Integer.parseInt(category)), -1, student, studentclass, project, comment);
           out.println(JobDAO.insert(job));

        %>.</h2>
        <br>
        <a href="index.jsp">back to order page</a>
    </fieldset>
</body>
</html>
