 <%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 17.07.2019
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <u:html title="test"></u:html>
 <form method="post" action="/login.html" >
     <h1>sad</h1>
     <label for="login">Имя пользователя:</label>
     <input type="text" id="login" name="name">
     <label for="password">Пароль:</label>
     <input type="password" id="password" name="password">
     <button type="submit">Войти</button>
 </form>
 <a href="registration.html">регистрация</a>
 <c:out value="${res}"/>
 </body>
 </html>
