<%@ page import="Database" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="refresh" content="0; results.jsp" />
		<title>Processing...</title>
	</head>
	<body>
		<%

			Database db = new Database("10.0.0.254", "htl_mtbrace", "user", "PeterRendl69!");

			String name = request.getParameter("name");
			String category = request.getParameter("category");
			String minutes = request.getParameter("minutes");
			String seconds = request.getParameter("seconds");
			String hseconds = request.getParameter("hseconds");

			double mins = Double.valueOf(minutes);
			double secs = Double.valueOf(seconds);
			double hsecs = Double.valueOf(hseconds);

			double time = mins * 60 + secs + hsecs / 100;


			db.Update("INSERT INTO entries (name, category, time) VALUES (?, ?, ?);", name, category, time + "");
			
			String output = "Name: " + name + ", Category: " + category + ", Time: " + minutes + ":" + seconds + ":" + hseconds;
			out.println(output);
			System.out.println(output);
			db.CloseConnection();
		%>
	</body>
</html>