<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 14.08.2019
  Time: 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="ActiveDelivery">
<div class="row">
    <div class="col s8 offset-s2">
        <table>
            <thead>
            <tr>
                <th><fmt:message key="OrderID" bundle="${value}"/></th>
                <th><fmt:message key="UserTelephone" bundle="${value}"/></th>
                <th><fmt:message key="Done" bundle="${value}"/></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${listDelivery}" var="delivery">
                <tr id="order${delivery.order.id}">
                    <td>${delivery.order.id}</td>
                    <td>${delivery.user.telephone}</td>
                    <td><div onclick="doneOrder(${delivery.order.id},${delivery.courier.id})" style="cursor: pointer;">
                        <i  class="material-icons">done</i></div>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
    <script>
        <%@include file="/WEB-INF/js/courier-done.js"%>
    </script>
</u:html>
