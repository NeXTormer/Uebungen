<%@ page import="database.Database" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 15/11/2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing...</title>
</head>
<body>

<%

    String gender = request.getParameter("gender");
    String age = request.getParameter("age");
    String behaviour = request.getParameter("behaviour");

    Database db = new Database("faoiltiarna.ddns.net", "htl_raucherumfrage", "holz", "PeterRendl69!");

    db.Update("INSERT INTO participant (age, gender, category) VALUES (?, ?, ?);", age, gender, behaviour);



%>

<meta http-equiv="refresh" content="0; url=results.jsp" />


</body>
</html>
