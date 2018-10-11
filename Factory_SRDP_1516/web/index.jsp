<%@ page import="database.Database" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/10/2018
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HTL Factory</title>
      <style>
          fieldset
          {
              background-color: #FFFFCC;
          }
      </style>

  </head>
  <body>

  <h1>New Order</h1>
  <br>
  <br>
  <fieldset>
      <form id="mainform" action="process.jsp">
          <table>
              <tr>
                  <td>
                      Type of order:
                  </td>
                  <td>
                      <select name="category">
                          <%
                              Database db = new Database("faoiltiarna.ddns.net", "htl_factory", "user", "PeterRendl69!");
                              ResultSet categories = db.Query("SELECT * FROM category;");
                              while(categories.next())
                              {
                                  out.println("<option value=\"" + categories.getInt(1) + "\">" + categories.getString(2) + "</option>");
                              }
                              db.CloseConnection();
                          %>
                      </select>

                  </td>
              </tr>
              <tr>
                  <td>
                      Student/Team:
                  </td>
                  <td>
                      <input name="orderedby">
                  </td>
              </tr>
              <tr>
                  <td>
                      Class:
                  </td>
                  <td>
                      <input name="studentclass">
                  </td>
              </tr>
              <tr>
                  <td>
                      Project:
                  </td>
                  <td>
                      <input name="project">
                  </td>
              </tr>
              <tr>
                  <td>
                      Comment:
                  </td>
                  <td>
                      <!-- <textarea rows="2" name="comment" form="mainform"></textarea> -->
                      <input name="comment">
                  </td>
              </tr>
              <tr>
                  <td>
                      <input type="submit">
                      <input type="reset">
                  </td>

              </tr>
          </table>
      </form>


  </fieldset>

  <br>

  <h2>Overview</h2>

  <fieldset>
      <a href="orders.jsp">show order overview</a>
  </fieldset>


  </body>
</html>
