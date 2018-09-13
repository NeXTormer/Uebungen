<%@page import="at.htlklu.fsst.Database"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Processing data...</title>
</head>
<body>

<%
	String description = request.getParameter("description");
	String subject = request.getParameter("subject");
	String duedate = request.getParameter("duedate");
	
	Database db = new Database("localhost", "htl_homework_tracker", "root", "");
	db.update("INSERT INTO tasks (description, subject, duedate) VALUES (\"" + description + "\", \"" + subject+ "\", \"" + duedate + "\");");
	

	out.println(description);

%>

<a href="tasks.jsp">Show Tasks</a>
</body>
</html>