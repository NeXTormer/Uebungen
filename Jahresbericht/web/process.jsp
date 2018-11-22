<%@ page import="database.Database" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 22/11/2018
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing...</title>
</head>
<body>

<%

    Database db = new Database("faoiltiarna.ddns.net", "htl_jahresbericht", "user", "PeterRendl69!");



    String author = request.getParameter("author").trim();
    String title = request.getParameter("title").trim();
    String subtitle = request.getParameter("subtitle").trim();
    String text = request.getParameter("text").trim();

    String visibility = request.getParameter("public");

    if(title == "" || text == "")
    {
        out.println("<meta http-equiv=\"refresh\" content=\"0; url=index.jsp?valid=false\" />");
    }

    db.Update("INSERT INTO articles (author, title, subtitle, text, public, timestamp) VALUES (?, ?, ?, ?, ?, now());", author, title, subtitle, text, (visibility.equals("public") ? "1" : "0"));




%>

</body>
</html>
