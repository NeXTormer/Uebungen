<%@ page import="company.database.Database" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="objects.Participant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
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

    Database db = new Database("faoiltiarna.ddns.net", "htl_skirace_2", "user", "PeterRendl69!");

    ArrayList<Participant> participants;

    participants = Participant.loadParticipants(db.getConnection());
    Collections.sort(participants);

    out.println(Participant.getHTMLTable(participants));



    db.CloseConnection();
%>


</body>
</html>