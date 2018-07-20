<%@ page import="company.database.Database" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel=stylesheet type=text/css href="style.css">
    <link rel="shortcut icon" href="isdn.png">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Race Results</title>
</head>
<body>

<%
    Database db = new Database("10.0.0.254", "htl_mtbrace", "user", "PeterRendl69!");

    out.println(db.GenerateTable("SELECT id as ID, name as Name, category as Kategorie, time as Zeit FROM entries ORDER BY time ASC;"));

    db.CloseConnection();

%>

<a href="index.html">Return to Home</a>
</body>
</html>