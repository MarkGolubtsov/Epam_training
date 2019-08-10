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
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <fmt:setLocale value="${language}" scope="session"/>
 <fmt:setBundle basename="lang" var="value"/>
 <u:html title="login">
     <div class="section"></div>
     <form method="post" action="/shop/login">
         <center>
             <h5 class="indigo-text"><fmt:message key="Login_message" bundle="${value}"/></h5>
             <div class="section"></div>
             <div class="container">
                 <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                     <form class="col s12" action="/shop/login" method="post">
                         <div class='row'>
                             <div class='col s12'>
                             </div>
                         </div>

                         <div class='row'>
                             <div class='input-field col s12'>
                                 <input required pattern="[a-zA-Z]" class='validate' type='text' name='name' id='email' />
                                 <label for='email'><fmt:message key="Enter_name" bundle="${value}"/></label>
                             </div>
                         </div>

                         <div class='row'>
                             <div class='input-field col s12'>
                                 <input  required class='validate' type='password' name='password' id='password' />
                                 <label for='password'><fmt:message key="Enter_password" bundle="${value}"/></label>
                             </div>
                         </div>
                         <br />
                         <center>
                             <div class='row'>
                                 <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'><fmt:message key="Signin" bundle="${value}"/></button>
                             </div>
                         </center>
                     </form>
                 </div>
             </div>
             <a href="/shop/registration"><fmt:message key="Create_account" bundle="${value}"/></a>
         </center>
         <div class="section"></div>
         <div class="section"></div>
     </form>

 </u:html>



