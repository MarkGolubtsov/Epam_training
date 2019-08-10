<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 23.07.2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="registration"></u:html>
<div class="section"></div>
<div>
    <center>
        <h5 class="indigo-text"><fmt:message key="Registration" bundle="${value}"/></h5>
        <div class="section"></div>
        <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                <form action="/shop/registration"  class="col s12" method="post">
                    <div class='row'>
                        <div class='col s12'>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate   ' type='text' name='name' id='email' />
                            <label  for='email'><fmt:message key="Enter_name" bundle="${value}"/></label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='password' name='password' id='password' />
                            <label  for='password'><fmt:message key="Enter_password" bundle="${value}"/></label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='tel' id='tel' />
                            <label for='tel'><fmt:message key="Enter_telephone" bundle="${value}"/></label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='street' id='street' />
                            <label for='street'><fmt:message key="Enter_street" bundle="${value}"/></label>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='house' id='house' pattern="[0-9]+"/>
                            <label for='house'><fmt:message key="Enter_house" bundle="${value}"/></label>
                        </div>
                    </div>

                    <br />

                    <p class="align left">
                        <label>
                            <input  type="checkbox" class="filled-in  indigo"  name="role" value="USER"/>
                            <span><fmt:message key="USER" bundle="${value}"/></span>
                        </label>
                    </p>
                    <br/>
                    <p class="align left">
                        <label>
                            <input type="checkbox" class="filled-in"  name="role" value="COURIER"/>
                            <span><fmt:message key="COURIER" bundle="${value}"/></span>
                        </label>
                    </p>

                    <center>
                        <div class='row'>
                            <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'><fmt:message key="Registration" bundle="${value}"/></button>
                        </div>
                    </center>
                </form>
            </div>
        </div>

        <a href="/shop/login">Login</a>
    </center>
    <div class="section"></div>
    <div class="section"></div>
</div>
<script>
    $(document).ready(function(){
        $('.filled-in').click(function() {
            $('.filled-in').not(this).prop('checked', false);
        });
    });
</script>

