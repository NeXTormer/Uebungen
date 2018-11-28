<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 28/11/2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Homework Tracker</title>
  </head>
  <body>

  <h1>Track your homework with HTL Moessigerstrasse</h1>
  Enter your pending task and select a subject.
  <br>
  <form action="process.jsp">

    <table>
      <tr>
        <td colspan="2">Description</td>
      </tr>
      <tr>
        <td colspan="2"><input type="text" name="description"></td>
      </tr>
      <tr>
        <td>Due Date</td>
        <td>Subject</td>
      </tr>
      <tr>
        <td><input type="text" name="duedate"></td>
        <td><select name="subject">
              <option>FSST</option>
              <option>HWE</option>
            </select>
        </td>
      </tr>
      <tr>
        <td><input type="submit"></td>
        <td><a href="list.jsp">Show list of tasks</a></td>
      </tr>
    </table>


  </form>



  </body>
</html>
