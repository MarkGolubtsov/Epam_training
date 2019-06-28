<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 28.06.2019
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bot</title>
</head>
<body>
<section>
    <h3>Bot info</h3>
    <jsp:useBean id="flower" scope="request" type="entity.Flower"/>
    <tr>
        <td>ID: ${flower} | Name: ${flower.name} | Serial number: ${bot.serial}</td>
        <td><a href="result.jsp?">Update</a></td>
    </tr>
</section>
</body>
</html>
