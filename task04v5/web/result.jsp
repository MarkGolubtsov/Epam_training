<%@ page import="entity.Flower" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 28.06.2019
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Out</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<a href="index">Back</a>
<c:out value="{1+5*9}"/>
<table class="striped">
    <thead>
    <tr>
        <th>Parser</th>
        <th>Name</th>
        <th>ID</th>
        <th>Origin</th>
        <th>Soil</th>
        <th>Multiplying</th>
        <th>Temperature</th>
        <th>Watering</th>
        <th>is LikeLighting?</th>
        <th>Color</th>
        <th>Size</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<String> lists= new ArrayList<>();
        lists.add("listDom");
        lists.add("listSax");
        lists.add("listStax");
        for (String list:
             lists) {
            List<Flower> flowers = (List<Flower>) request.getAttribute(list);
            if (flowers != null && !flowers.isEmpty()) {
                for (Flower s : flowers) {
                    out.println("<tr>");
                    out.println("<td>"+list.substring(4)+"</td>");
                    out.println("<td>" + s.getName() + "</td>");
                    out.println("<td>" + s.getID() + "</td>");
                    out.println("<td>" + s.getOrigin() + "</td>");
                    out.println("<td>" + (s.getSoil()).getType() + "</td>");
                    out.println("<td>" + s.getMultiplying().getType() + "</td>");
                    out.println("<td>" + s.getGrowingTips().getTemperature() + "</td>");
                    out.println("<td>" + s.getGrowingTips().getWatering() + "</td>");
                    out.println("<td>" + s.getGrowingTips().isLikeLighting() + "</td>");
                    out.println("<td>" + s.getVisual().getColor() + "</td>");
                    out.println("<td>" + s.getVisual().getSize() + "</td>");
                    out.println("</tr>");
                }
            }

        }

    %>

    </tbody>
</table>



</body>
</html>
