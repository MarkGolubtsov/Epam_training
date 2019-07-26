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
 <u:html title="login"></u:html>
<%-- <form method="post" action="/login.html" >--%>
<%--     <label for="login">Имя пользователя:</label>--%>
<%--     <input type="text" id="login" name="name">--%>
<%--     <label for="password">Пароль:</label>--%>
<%--     <input type="password" id="password" name="password">--%>
<%--     <button type="submit">Войти</button>--%>
<%-- </form>--%>
<%-- <html>--%>

 <head>
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<%--     <style>--%>
<%--         body {--%>
<%--             display: flex;--%>
<%--             min-height: 100vh;--%>
<%--             flex-direction: column;--%>
<%--         }--%>

<%--         main {--%>
<%--             flex: 1 0 auto;--%>
<%--         }--%>

<%--         body {--%>
<%--             background: #fff;--%>
<%--         }--%>

<%--         .input-field input[type=date]:focus + label,--%>
<%--         .input-field input[type=text]:focus + label,--%>
<%--         .input-field input[type=email]:focus + label,--%>
<%--         .input-field input[type=password]:focus + label {--%>
<%--             color: #e91e63;--%>
<%--         }--%>

<%--         .input-field input[type=date]:focus,--%>
<%--         .input-field input[type=text]:focus,--%>
<%--         .input-field input[type=email]:focus,--%>
<%--         .input-field input[type=password]:focus {--%>
<%--             border-bottom: 2px solid #e91e63;--%>
<%--             box-shadow: none;--%>
<%--         }--%>
<%--     </style>--%>
 </head>
 <div class="section"></div>
 <form method="post" action="/login.html">
     <center>
         <h5 class="indigo-text">Please, login into your account</h5>
         <div class="section"></div>
         <div class="container">
             <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                 <form class="col s12" method="post">
                     <div class='row'>
                         <div class='col s12'>
                         </div>
                     </div>

                     <div class='row'>
                         <div class='input-field col s12'>
                             <input class='validate' type='text' name='name' id='email' />
                             <label for='email'>Enter your email</label>
                         </div>
                     </div>

                     <div class='row'>
                         <div class='input-field col s12'>
                             <input class='validate' type='password' name='password' id='password' />
                             <label for='password'>Enter your password</label>
                         </div>
                     </div>
                     <br />
                     <center>
                         <div class='row'>
                             <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>
                         </div>
                     </center>
                 </form>
             </div>
         </div>
         <a href="registration.html">Create account</a>
     </center>
     <div class="section"></div>
     <div class="section"></div>
 </form>


