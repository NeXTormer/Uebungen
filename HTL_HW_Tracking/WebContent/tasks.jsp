<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="at.htlklu.fsst.Database"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
</head>
<body>

<table>
	<tr>
		<th>Due Date</th>
		<th>Description</th>
		<th>Subject</th>
	</tr>
	
	<%
	
		Database db = new Database("localhost", "htl_homework_tracker", "root", "");
	
		ResultSet rs = db.query("SELECT * FROM tasks ORDER BY duedate DESC;");
	
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		while(rs.next())
		{
			out.println("<tr>");

			out.println("<td>");
			out.println(rs.getString(4));
			out.println("</td>");
			
			out.println("<td>");
			out.println(rs.getString(2));
			out.println("</td>");
			
			out.println("<td>");
			out.println(rs.getString(3));
			out.println("</td>");
			
			out.println("</tr>");
		}
	%>
	
</table>

</body>
</html>

<style>

body
{
	background-color: lightgray;
}

table
{
	padding: 5px;
}

tr, th, td
{
	padding: 4px;
	border: 1px solid black;
}

 
</style>