<%@ page import="company.database.Database" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Race Results</title>
</head>
<body>
<%!


    public String table() {

        return null;

    }
%>

<%
    Database db = new Database("faoiltiarna.ddns.net", "htl_mtbrace", "user", "PeterRendl69!");

    out.println(db.GenerateTable("SELECT * FROM entries;"));


%>
</body>
</html>