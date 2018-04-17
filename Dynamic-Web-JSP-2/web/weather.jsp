<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 16/04/2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="company.database.Database" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Weather</title>
</head>
<body>

<b>Wetter in Neumarkt in der Steiermark</b>
<br>
<br>
<%
    Database db = new Database("faoiltiarna.ddns.net", "iot_the_operator", "user", "PeterRendl69!");

    ResultSet rs = db.Query("SELECT * FROM weather1 WHERE deviceid = 6 order by id desc limit 1;");

    int temp = -1;
    double hum = 0;
    String time = "[]";

    while(rs.next())
    {
        temp = rs.getInt(2);
        hum = rs.getDouble(3);

        time = rs.getString(5);

    }
    out.println("<b>Time: </b>" + time);
    out.println("<br>");
    out.println("<b>Temperature: </b>" + temp + "°C<br><b>Humidity: </b>" + hum + "%");
%>

</body>
</html>
