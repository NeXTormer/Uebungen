<%@ page import="java.util.ArrayList" %>
<%@ page import="factory.Category" %>
<%@ page import="factory.db.CategoryDAO" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 04/05/2019
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Factory</title>
  </head>
  <body>

  <h1>HTL Factory Order System</h1>
  <h2>New Order</h2>
  <br>
  <fieldset>
    <form action="process.jsp">
      <table>
        <tr>
          <td>Type of order:</td>
          <td>
            <select name="category">
              <%
                ArrayList<Category> categories = CategoryDAO.getAllCategories();
                for(Category c : categories)
                {
                    out.println(c.toHTMLOptionElement());
                }
              %>
            </select>
          </td>
        </tr>
        <tr>
          <td>Student/Team:</td>
          <td>
            <input name="student">
          </td>
        </tr>
        <tr>
          <td>Class:</td>
          <td>
            <input name="class">
          </td>
        </tr>
        <tr>
          <td>Project:</td>
          <td>
            <input name="project">
          </td>
        </tr>
        <tr>
          <td>Comment</td>
          <td>
            <input name="comment">
          </td>
        </tr>
        <tr>
          <td></td>
          <td>
            <input type="submit" value="Send">
            <input type="reset" value="Clear">
          </td>
        </tr>

      </table>
    </form>
  </fieldset>
  <h2>Overview</h2>
  <fieldset>
    <a href="overview.jsp">show order overview</a>
  </fieldset>
  </body>
</html>
