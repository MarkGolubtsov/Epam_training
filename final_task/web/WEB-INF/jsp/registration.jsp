<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 23.07.2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/registration.html" >
    <h1>sad</h1>
    <label for="login">Имя пользователя:</label>
    <input type="text" id="login" name="name">

    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password">

    <label for="tel">Телефон:</label>
    <input type="password" id="tel" name="tel">

    <label for="USER">USER:</label>
    <input type="checkbox"  id="USER" name="role" value="USER">

    <label for="COURIER">COURIER:</label>
    <input type="checkbox"  id="COURIER" name="role" value="COURIER">
    <button type="submit">зарегестрироваться</button>
</form>
</body>
</html>
<%
    Boolean res1 = (Boolean) request.getAttribute("result");
    if(res1!=null) {
        if (res1.booleanValue() == true)
            out.println("Регистрация прошла успешно");
        else out.println("RIP");
    }
%>
