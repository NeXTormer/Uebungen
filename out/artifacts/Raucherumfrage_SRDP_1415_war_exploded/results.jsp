<%@ page import="objects.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.Database" %>
<%@ page import="objects.Group" %>
<%@ page import="objects.CategoryEntry" %><%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 15/11/2018
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Results</title>
    <fieldset>
        <h1>Rauchen in der Schule</h1>
        <h2>Aktuelles Ergebnis der Umfrage</h2>


        <table border="1">
            <tr>
                <th rowspan="2">Gruppe</th>
                <%


                    Database db = new Database("faoiltiarna.ddns.net", "htl_raucherumfrage", "holz", "PeterRendl69!");

                    ArrayList<Category> cats = Category.loadCategories(db);
                    for(int i = 0; i < cats.size(); i++)
                    {
                        out.println("<th colspan=3>" + cats.get(i).getShortName() + "</th>");
                    }
                    out.println("</tr><tr>");

                    for(int i = 0; i < cats.size(); i++)
                    {
                        out.println("<th>M</th>");
                        out.println("<th>W</th>");
                        out.println("<th>Gesamt</th>");
                    }

                    out.println("</tr><tr>");

                    Group g1 = new Group(0, 10, db);

                    out.println("<td>" + g1.m_Name + "</td>");

                    for(CategoryEntry ce : g1.m_Entries)
                    {
                        out.println("<td>" + ce.m_M + "</td>");
                        out.println("<td>" + ce.m_F + "</td>");
                        out.println("<td>" + ce.m_Total + "</td>");
                    }
                    out.println("</tr><tr>");

                Group g2 = new Group(10, 14, db);

                out.println("<td>" + g2.m_Name + "</td>");

                for(CategoryEntry ce : g2.m_Entries)
                {
                    out.println("<td>" + ce.m_M + "</td>");
                    out.println("<td>" + ce.m_F + "</td>");
                    out.println("<td>" + ce.m_Total + "</td>");
                }
                out.println("</tr><tr>");

                Group g3 = new Group(15, 18, db);

                out.println("<td>" + g3.m_Name + "</td>");

                for(CategoryEntry ce : g3.m_Entries)
                {
                    out.println("<td>" + ce.m_M + "</td>");
                    out.println("<td>" + ce.m_F + "</td>");
                    out.println("<td>" + ce.m_Total + "</td>");
                }
                out.println("</tr><tr>");

                Group g4 = new Group(18, 0, db);

                out.println("<td>" + g4.m_Name + "</td>");

                for(CategoryEntry ce : g4.m_Entries)
                {
                    out.println("<td>" + ce.m_M + "</td>");
                    out.println("<td>" + ce.m_F + "</td>");
                    out.println("<td>" + ce.m_Total + "</td>");
                }
                out.println("</tr><tr>");

            %>

            </tr>
        </table>
    </fieldset>
</head>
<body>

</body>
</html>
