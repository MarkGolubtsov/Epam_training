<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--    <c:if test="${not empty authorizedUser}">--%>
<c:url value="/shop/logout" var="logOut"/>
<c:url value="/shop/login" var="login"/>
<c:url value="/shop/product/list" var="listProduct"/>
<c:url value="/shop/main" var="main"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
    <nav class="indigo">
            <a href="#" class="brand-logo right ">
                <fmt:message key="logo" bundle="${value}"/></a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul id="nav-wrapper" class="left hide-on-med-and-down indigo ">
                <c:if test="${not empty authorizedUser}">
                    <li ><a href="${logOut}"><i class="material-icons"> exit_to_app</i></a></li>
                    <c:forEach items="${menu}" var="item">
                        <c:url value="${item.url}" var="itemUrl"/>
                        <c:if test="${item.name=='Cart'}">
                            <li><a href="${itemUrl}"> <fmt:message key="Cart" bundle="${value}"/><i class="material-icons left">shopping_cart</i>
                                <span   onload="updateCart()" id="itemCount" class="new  badge red"></span>
                            </a>
                            </li>
                        </c:if>

                        <c:if test="${not (item.name=='Cart')}">
                            <li><a href="${itemUrl}"> <fmt:message key="${item.name}" bundle="${value}"/>
                                <c:if test="${not empty item.icon}">
                                    <i class="material-icons left">${item.icon}</i>
                                </c:if>
                            </a></li>
                        </c:if>

                    </c:forEach>
                </c:if>

                <c:if test="${empty authorizedUser}">
                    <li><a href="${login}"> <fmt:message key="Login" bundle="${value}"/></a></li>
                </c:if>
                <li><a href="${listProduct}"><fmt:message key="Product" bundle="${value}"/></a></li>
                <li><a href="${main}"> <fmt:message key="Main" bundle="${value}"/></a></li>
<%--                <li ><a class="align:center"><img style="align:center" class="RUS" src="/img/Russia.png"></a></li>--%>
<%--                <li ><a><img style="align:center" class="ENG" src="/img/England.png"></a></li>--%>
<%--                <li ><a><img  style="align:center" class="ZH" src="/img/China.png"></a></li>--%>
<%--                <li><a class="RUS"> <fmt:message key="RUS" bundle="${value}"/></a></li>--%>
<%--                <li><a class="ENG"> <fmt:message key="ENG" bundle="${value}"/></a></li>--%>
<%--                <li><a class="ZH"> <fmt:message key="ZH" bundle="${value}"/></a></li>--%>

            </ul>
        <img  class="RUS" src="/img/Russia.png">
        <img  class="ENG" src="/img/England.png">
        <img   class="ZH" src="/img/China.png">
        </div>
    </nav>


<ul class="sidenav" id="mobile-demo">
    <c:if test="${not empty authorizedUser}">
        <li ><a href="${logOut}"><i class="material-icons"> exit_to_app</i></a></li>
        <c:forEach items="${menu}" var="item">
            <c:url value="${item.url}" var="itemUrl"/>
            <c:if test="${item.name=='Cart'}">
                <li><a href="${itemUrl}"> <fmt:message key="Cart" bundle="${value}"/><i class="material-icons left">shopping_cart</i>
                    <span   onload="updateCart()" id="itemCount" class="new  badge red"></span>
                </a>
                </li>
            </c:if>

            <c:if test="${not (item.name=='Cart')}">
                <li><a href="${itemUrl}"> <fmt:message key="${item.name}" bundle="${value}"/>
                    <c:if test="${not empty item.icon}">
                        <i class="material-icons left">${item.icon}</i>
                    </c:if>
                </a></li>
            </c:if>

        </c:forEach>
    </c:if>

    <c:if test="${empty authorizedUser}">
        <li><a href="${login}"> <fmt:message key="Login" bundle="${value}"/></a></li>
    </c:if>
    <li><a href="${listProduct}"><fmt:message key="Product" bundle="${value}"/></a></li>
    <li><a href="${main}"> <fmt:message key="Main" bundle="${value}"/></a></li>
    <li><a class="RUS"> <fmt:message key="RUS" bundle="${value}"/></a></li>
    <li><a class="ENG"> <fmt:message key="ENG" bundle="${value}"/></a></li>
    <li><a class="ZH"> <fmt:message key="ZH" bundle="${value}"/></a></li>

</ul>

<script >
    <%@include file="/WEB-INF/js/navbar-sidenav-initialize.js"%>
</script>
<%--    </c:if>--%>
