<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 08.08.2019
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="Products">
    <div id="Profile">
        <div class="row">
            <div class="input-field  col s4 offset-s4">
                <input required id="name" type="text" value="${name}">
                <label for="name"><fmt:message key="Name" bundle="${value}"/></label>
            </div>
        </div>
        <div class="row">
            <div class="input-field  col s4 offset-s4">
                <input  required id="tel" type="text" value="${telephone}">
                <label for="tel"><fmt:message key="Telephone" bundle="${value}"/></label>
            </div>
        </div>
                <div class="row">
                    <div class="input-field  col s4 offset-s4">
                        <input  required id="street" type="text" value="${street}">
                        <label for="street"><fmt:message key="Street" bundle="${value}"/></label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field  col s4 offset-s4">
                        <input class='validate'  pattern="[0-9]+" required id="house" type="text" value="${house}">
                        <label for="house"><fmt:message key="House" bundle="${value}"/></label>
                    </div>
                </div>

        <div class="row">
            <div class="col s12 center-align">
                <a id ="SaveButton" class=" btn waves-effect waves-green indigo"><fmt:message key="Save" bundle="${value}"/></a>
                <label for="SaveButton" id="result"></label>
            </div>
        </div>
    </div>
<script>
    <%@include file="/WEB-INF/js/profile.js"%>
    <%@include file="/WEB-INF/js/translate.js"%>
    </script>
</u:html>