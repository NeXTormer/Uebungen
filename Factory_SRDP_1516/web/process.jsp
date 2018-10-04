<%@ page import="database.Database" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/10/2018
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order confirmation</title>
</head>
<body>

<fieldset>
    <h1>Thank you for your order!</h1>
    <br>
    <h2><%

        String category = request.getParameter("category");
        String orderedby = request.getParameter("orderedby");
        String project = request.getParameter("project");
        String studentclass = request.getParameter("studentclass");
        String comment = request.getParameter("comment");

        Database db = new Database("faoiltiarna.ddns.net", "htl_factory", "user", "PeterRendl69!");


        ResultSet catid = db.Query("SELECT id FROM category WHERE name = \"" + category + "\";");
        catid.next();
        int catidint = catid.getInt(1);


        out.println(studentclass);

        int orderid = db.Update("INSERT INTO orders (orderedby, category, schoolclass, projectname, comment) VALUES (?, ?, ?, ?, ?);", orderedby, String.valueOf(catidint), studentclass, project, comment);

        if(orderid > 0)
        {
            out.println("Your order number is " + orderid + ".");
        }
        else
        {
            out.println("Error");
        }


    %></h2>
    <br>
    <br>
    <a href="index.jsp">back to order page</a>

</fieldset>

</body>
</html>
