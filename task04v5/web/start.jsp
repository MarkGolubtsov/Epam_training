<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 28.06.2019
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bot</title>
</head>
<body>
<section>
    <h3>Bot info</h3>
    <jsp:useBean id="flower" scope="request" type="entity.Flower"/>
    <tr>
        <td>ID: ${} | Name: ${bot.name} | Serial number: ${bot.serial}</td>
        <td><a href="bot?action=update">Update</a></td>
    </tr>
</section>
</body>
</html>
