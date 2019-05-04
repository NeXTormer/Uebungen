<%@ page import="factory.db.JobDAO" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/05/2019
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete...</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    JobDAO.delete(Integer.parseInt(id));

%>

<meta http-equiv="refresh" content="0; url=overview.jsp" />


</body>
</html>
