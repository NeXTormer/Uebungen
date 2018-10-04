<%--
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
  </head>
  <body>

  <strong>New Order</strong>
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
                          <option value="1">3D Print</option>
                          <option value="2">Lasercut</option>
                          <option value="3">PCB</option>
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
                      <input name="studenclass">
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




  </body>
</html>
