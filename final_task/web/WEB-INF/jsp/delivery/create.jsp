<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 13.08.2019
  Time: 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<script >
    <%@include file="/WEB-INF/js/translate.js"%>
</script>
<u:html title="Create delivery">
    <div class="row">
        <div id="Users" class="col s4">
            <table class="centered">
                <thead>
                <tr>
                    <th><fmt:message key="OrderID" bundle="${value}"/></th>
                    <th><fmt:message key="Select" bundle="${value}"/></th></th>
                    <th><fmt:message key="Info" bundle="${value}"/></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Orders}" var="order">
                    <tr id='tr${order.id}'>
                        <td>${order.id}</td>
                        <td>
                            <label>
                            <input id="addOrder${order.id}" data-order-id="${order.id}"  data-total_price='${order.total_price}' data-user-id="${order.user.id}" type="checkbox" />
                            <span></span>
                            </label>
                        </td>
                        <td>
                           <a href="#modal${order.id}" class="secondary-content modal-trigger" data-delivery="${order.delivery}" data-total_price="${order.total_price}" data-type-pay="${order.type_pay}" data-orderId="${order.id}"><i class="material-icons">info</i></a>
                       </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div id="info_abount_order"></div>
        </div>

        <div id='Create' class="col s4">
            <div class="row">
                <ul class="collection with-header">
                    <li class="collection-header">
                        <div class="row">
                            <h4 class="align center "><fmt:message key="Delivery" bundle="${value}"/></h4>
                        </div>

                        <div class="row">
                            <div class="col s12" id='delivery'  style='overflow: hidden;'>
                                <div class="row">
                                    <div class="col s6">
                                        <div class="row">
                                            <div class="col s12">
                                                <div class="col s10">
                                                    <fmt:message key='UserID' bundle='${value}'/>:
                                                </div>
                                                <div id="user_id" class="col s1"></div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col s12">
                                                <div class="col s10">
                                                    <fmt:message key='OrderID' bundle='${value}'/>:
                                                </div>
                                                <div data-total_price="0" id="order_id" class="col s2"></div>
                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="col s12">
                                                <div class="col s10">
                                                    <fmt:message key='CourierID' bundle='${value}'/>:
                                                </div>
                                                <div id="courier_id" class="col s2"></div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col s6">
                                        <a  onclick="createDelivery()" id="CreateDelivery" class="waves-effect waves-green btn-small indigo"> <fmt:message key='Create_delivery' bundle='${value}'/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

        </ul>

        </div>
        <div class="col s4" id="Couriers">
            <table class="centered">
                <thead>
                <tr>
                    <th><fmt:message key="CourierID" bundle="${value}"/></th>
                    <th><fmt:message key="Name" bundle="${value}"/></th></th>
                    <th><fmt:message key="Select" bundle="${value}"/></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Couriers}" var="courier">
                    <tr>
                        <td>${courier.id}</td>
                        <td>${courier.name}</td>
                        <td>
                            <label>
                                <input id="addCourier${order.id}" data-courier-id="${courier.id}" type="checkbox" />
                                <span></span>
                            </label>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        <%@include file="/WEB-INF/js/orders.js"%>
        <%@include file="/WEB-INF/js/create-delivery.js"%>
    </script>

    <c:forEach items="${Orders}" var="order">
        <script>
            addAdress(${order.id},${order.user.id});
        </script>
    </c:forEach>
</u:html>
