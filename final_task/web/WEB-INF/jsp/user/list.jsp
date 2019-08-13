<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 12.08.2019
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="ListUser">

    <script>
        <%@include file="/WEB-INF/js/translate.js"%>
        <%@include file="/WEB-INF/js/admin-listUser.js"%>
    </script>

    <div class="row">
        <div class="col s9 offset-s1">
                <ul id = 'main' class="collapsible popout ">
                    <c:forEach items="${listUsers}" var="user">
                        <li>
                            <div class="collapsible-header">
                                <i class="material-icons">info</i>
                                <fmt:message key="Name" bundle="${value}"/>:${user.name}
                                <span class="align right">
                                <span style="margin: 0% 0% 0% 10px" class="UserRole${user.id}"> <fmt:message key="Role" bundle="${value}"/> ${user.role}</span>
                                </span>
                            </div>
                            <div style="background: white" class="collapsible-body">
                                <div class="row">
                                    <div class="col s3">
                                        <fmt:message key="Id" bundle="${value}"/>:${user.id}
                                    </div>
                                    <div class="col s3">
                                        <fmt:message key="Name" bundle="${value}"/>:${user.name}
                                    </div>
                                    <div class="col s3">
                                        <fmt:message key="Role" bundle="${value}"/>:
                                        <span class="UserRole${user.id}">${user.role}</span>
                                    </div>
                                    <div class="col s3">
                                        <fmt:message key="Telephone" bundle="${value}"/>:${user.telephone}
                                    </div>
                                </div>
                                <div id="changeRole${user.id}" class="row">
                                    <div class="col s12">
                                    <c:if test="${user.role!='ADMIN'}">
                                        <c:if test="${user.role !='USER'}">
                                            <div id="butUser${user.id}" class="col s6">
                                                <a onclick="makeUser(${user.id})"class="waves-effect waves-light btn-small blue align left"><fmt:message key="MakeUser" bundle="${value}"/></a>
                                            </div>
                                        </c:if>
                                        <c:if test="${user.role !='COURIER'}">
                                            <div id="butCourier${user.id}" class="col s6">
                                                <a  onclick="makeCourier(${user.id})"class="waves-effect waves-light btn-small blue"><fmt:message key="MakeCourier" bundle="${value}"/></a>
                                            </div>
                                        </c:if>
                                        <div class="col s6">
                                            <a  onclick="makeAdmin(${user.id})" class="waves-effect waves-light btn-small blue align right"><fmt:message key="MakeAdmin" bundle="${value}"/></a>
                                        </div>

                                    </c:if>
                                    </div>
                                </div>
                                <c:if test="${user.role=='USER'}">
                                    <div id='TableOrders${user.id}'class="row">
                                        <table class="centered">
                                            <thead>
                                            <tr>
                                                <th><fmt:message key="Id" bundle="${value}"/></th>
                                                <th><fmt:message key="Delivery" bundle="${value}"/></th>
                                                <th><fmt:message key="TypePay" bundle="${value}"/></th>
                                                <th><fmt:message key="Final_cost" bundle="${value}"/></th>
                                                <th><fmt:message key="Delete" bundle="${value}"/></th>
                                            </tr>
                                            </thead>
                                            <tbody id="bodyOrders${user.id}">
                                                <script>
                                                    getOrders(${user.id});
                                                </script>
                                            </tbody>
                                        </table>
                                        <script>
                                            checkAvailabilityOrders(${user.id});
                                        </script>
                                    </div>
                                </c:if>
                                <c:if test="${user.role=='COURIER'}">
                                    <div id="TableDeliveries${user.id}" class="row">
                                        <table class="centered">
                                            <thead>
                                            <tr>
                                                <th><fmt:message key="OrderID" bundle="${value}"/></th>
                                                <th><fmt:message key="UserID" bundle="${value}"/></th>
                                                <th><fmt:message key="UserTelephone" bundle="${value}"/></th>
                                                <th><fmt:message key="Cost" bundle="${value}"/></th>
                                                <th><fmt:message key="Delete" bundle="${value}"/></th>
                                            </tr>
                                            </thead>
                                            <tbody id="bodyDeliveries${user.id}">
                                            <script>
                                                getDelivery(${user.id});
                                            </script>
                                            </tbody>
                                        </table>
                                        <script>
                                            checkAvailabilityDeliveries(${user.id});
                                        </script>
                                    </div>

                                </c:if>

                            </div>
                        </li>
                    </c:forEach>
                </ul>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $('.collapsible').collapsible({
                accordion:false
            }
                );
        });

    </script>
</u:html>