<%@ page import="company.database.Database" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ski Race</title>
</head>
<body>

Race Results

<%

    Database db = new Database("10.0.0.254", "htl_skirace", "user", "PeterRendl69!");

    ResultSet rs = db.Query("SELECT * FROM participants ORDER BY total ASC;");

    out.println(db.PrintResultSetHTMLNice(rs));

    //db.CloseConnection();
%>


</body>
</html>