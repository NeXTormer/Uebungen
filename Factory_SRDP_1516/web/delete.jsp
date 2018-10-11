<%@ page import="database.Database" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 11/10/2018
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

<%

    Database db = new Database("faoiltiarna.ddns.net", "htl_factory", "user", "PeterRendl69!");
    String id = request.getParameter("id");

    db.Update("DELETE FROM orders WHERE id = ?;", id);


%>

<meta http-equiv="refresh" content="0; url=orders.jsp" />


</body>
</html>
