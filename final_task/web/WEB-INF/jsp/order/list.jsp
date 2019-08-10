<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 07.08.2019
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>

<u:html title="Orders">
    <div style="padding: 100px 100px 0px 100px" class="row">
        <ul class="collection with-header">
            <li class="collection-header"><h4>You Active Order</h4></li>
            <c:if test="${not empty listOrder}">
            <c:forEach items="${listOrder}" var="item">
            <li class="collection-item">
                <div><h5>Date:${item.date} <a data-delivery="${item.delivery}" data-total_price="${item.total_price}"data-type-pay="${item.type_pay}" data-orderId="${item.id}" href="#modal${item.id}" class="secondary-content modal-trigger">
                    <i class="material-icons">info</i></a>
                </h5>

                </div>
            </li>
            </c:forEach>
            </c:if>
            <c:if test="${empty listOrder}">
            <li class="collection-item">
                <div>You don't have any active orders.</div>
            </li>
            </c:if>

        </ul>
    </div>
    <div id="info_abount_order">

    </div>
    <script>
        <%@include file="/WEB-INF/js/orders.js"%>
    </script>
</u:html>
