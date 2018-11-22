<%@ page import="database.Database" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.Articles" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 22/11/2018
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Articles</title>
</head>
<body>

<h1>Jahresberichte einreichen</h1>
Liste der vorhandenen Jahresberichte
<br>

<%
    Database db = new Database("faoiltiarna.ddns.net", "htl_jahresbericht", "user", "PeterRendl69!");


    ArrayList<Articles> a = Articles.loadArticles(db);

    out.println("<table border=\"1\"><tr><th>Titel</th><th>Autor</th><th>Datum</th><th>Sichtbarkeit</th></tr>");
    for(Articles g : a)
    {
        out.println(g.toHTMLTableRow());
    }

    out.println("</table>");

%>

</body>
</html>
