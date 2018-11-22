<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 22/11/2018
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jahresberichte</title>
  </head>
  <body>



  <%
    try{
      if(request.getParameter("valid").equals("false"))
      {
        out.println("<font size=\"18\" color=\"red\">Ungueltige Eingabe</font>\n");
      }
    }
    catch (NullPointerException e)
    {

    }
  %>

  <form action="process.jsp">
    <h1>Jahresberichte einreichen</h1>
    Bitte geben sie den jahresbericht ein
    <br>
    <strong>Autor</strong>
    <br>
    <input name="author">
    <br>
    <strong>Titel*</strong>
    <br>
    <input name="title">
    <br>
    <strong>Untertitel</strong>
    <br>
    <input name="subtitle">
    <br>
    <strong>Text*</strong>
    <br>
    <input name="text">
    <br>
    <input type="radio" name="public" value="public" checked> Oeffentlich
    <input type="radio" name="public" value="private"> Intern

    <input type="submit">

  </form>


  </body>
</html>
