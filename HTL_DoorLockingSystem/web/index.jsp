<%@ page import="java.util.List" %>
<%@ page import="obj.Room" %>
<%@ page import="obj.RoomDAO" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 25/03/2019
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HTL Door Locking System</title>
  </head>
  <body>
  <h1>HTL Door Locking System</h1>
  <br>
  <form action="index.jsp">
    <select name="visibility">
      <option value="all">All</option>
      <option value="locked">Locked</option>
      <option value="unlocked">Unlocked</option>
    </select>

    <button type="submit">Show</button>

  </form>

  <br>

  <table>

    <tr>
      <th>Room</th>
      <th>Status</th>
    </tr>

    <%

      String visibility = request.getParameter("visibility");
      if(visibility == null) visibility = "";
      List<Room> rooms = RoomDAO.getAllRooms(visibility);

      for(Room r : rooms)
      {
        out.println("<tr>");
        out.println("<td>");
        out.println(r.getName());
        out.println("</td>");
        out.println("<td>");
        out.println(r.isLocked() ? "locked" : "unlocked");
        out.println("</td>");
        out.println("</tr>");
      }


    %>

  </table>


  </body>
</html>
