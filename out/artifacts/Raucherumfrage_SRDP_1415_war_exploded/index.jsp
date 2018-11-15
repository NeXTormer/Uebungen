<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 08/11/2018
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="database.Database" %>
<html>
  <head>
    <title>Raucherumfrage</title>

    <style>
      fieldset
      {
        background-color: #CCDDFF;
        width: 30%;
      }
      body
      {
        font-family: Arial;
      }
    </style>

  </head>
  <body>

  <fieldset>
    <form action="process.jsp">
    <h1>Rauchen in der Schule</h1>
    <h2>Umfrage</h2>
    <h3>Allgemeines:</h3>
      <table>
        <tr>
          <td>Alter:</td>
          <td><input type="text" name="age" size="2"></td>
        </tr>
        <tr>
          <td>Geschlecht:</td>
          <td>
            <select name="gender">
              <option value="M">M</option>
              <option value="F">F</option>
            </select>
          </td>
        </tr>
      </table>
    <br>
      <h3>Rauchverhalten:</h3>
      <%
        Database db = new Database("faoiltiarna.ddns.net", "htl_raucherumfrage", "holz", "PeterRendl69!");
        out.println(db.getCategoriesHTML());
        %>

    <br>
    <input type="submit" value="Absenden">
    </form>
  </fieldset>


  </body>
</html>
