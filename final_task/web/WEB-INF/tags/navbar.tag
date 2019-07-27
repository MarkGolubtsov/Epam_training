<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<%--    <c:if test="${not empty authorizedUser}">--%>
    <nav class="indigo">
            <a href="#" class="brand-logo right  ">Shop</a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul id="nav-mobile" class="left hide-on-med-and-down indigo ">
                <c:if test="${not empty authorizedUser}">
                    <li ><a href="/logout.html"><i class="material-icons"> exit_to_app</i></a></li>
                </c:if>
                <c:forEach items="${menu}" var="item">
                    <c:url value="${item.url}" var="itemUrl"/>

                    <c:if test="${item.name=='Basket'}">
                        <li><a href="${itemUrl}"><i class="material-icons">shopping_basket</i></a></li>
                    </c:if>

                    <c:if test="${not (item.name=='Basket')}">
                        <li><A href="${itemUrl}">${item.name}</A></li>
                    </c:if>

                </c:forEach>
                <c:if test="${empty authorizedUser}">
                    <li><a href="/login.html">Login</a></li>
                </c:if>
                <li><a href="/product/list.html">Product</a></li>
                <li><a href="/main.html">Main</a></li>
            </ul>
        </div>
    </nav>
<ul class="sidenav" id="mobile-demo">
    <c:forEach items="${menu}" var="item">
        <c:url value="${item.url}" var="itemUrl"/>
        <li class="m1 l2"><A href="${itemUrl}">${item.name}</A></li>
    </c:forEach>
    <c:if test="${not empty authorizedUser}">
        <li class="m1 l2"><a href="/logout.html">Выход</a></li>
    </c:if>

    <c:if test="${empty authorizedUser}">
        <li><a href="/login.html">Login</a></li>
    </c:if>
    <li><a href="/product/list.html">Продукты</a></li>
    <li><a href="/main.html">Главная</a></li>
</ul>

<%--    </c:if>--%>
