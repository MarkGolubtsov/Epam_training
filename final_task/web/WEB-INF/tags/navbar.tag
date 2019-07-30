<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    <%@include file="/WEB-INF/js/cart.js"%>
</script>
<%--    <c:if test="${not empty authorizedUser}">--%>
    <nav class="indigo">
            <a href="#" class="brand-logo right  ">Shop</a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul id="nav-wrapper" class="left hide-on-med-and-down indigo ">
                <c:if test="${not empty authorizedUser}">
                    <li ><a href="/shop/logout"><i class="material-icons"> exit_to_app</i></a></li>
                </c:if>
                <c:forEach items="${menu}" var="item">
                    <c:url value="${item.url}" var="itemUrl"/>

                    <c:if test="${item.name=='Cart'}">
                        <li><a href="${itemUrl}"><i class="material-icons left">shopping_cart</i>
                            ${item.name}
                            <span   onload="updateCart()" id="itemCount" class="new  badge red"></span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${not (item.name=='Cart')}">
                        <li><A href="${itemUrl}">${item.name}</A></li>
                    </c:if>

                </c:forEach>
                <c:if test="${empty authorizedUser}">
                    <li><a href="/shop/login">Login</a></li>
                </c:if>
                <li><a href="/shop/product/list">Product</a></li>
                <li><a href="/shop/main">Main</a></li>
            </ul>
        </div>
    </nav>


<ul class="sidenav" id="mobile-demo">
    <c:if test="${not empty authorizedUser}">
        <li ><a href="/shop/logout"><i class="material-icons"> exit_to_app</i></a></li>
    </c:if>
    <c:forEach items="${menu}" var="item">
        <c:url value="${item.url}" var="itemUrl"/>

        <c:if test="${item.name=='Cart'}">
            <li><a href="${itemUrl}"><i class="material-icons left">shopping_cart</i>
                    ${item.name}
                <span  id="itemCountMobile" class="new  badge red" ></span>
            </a>
            </li>
        </c:if>

        <c:if test="${not (item.name=='Cart')}">
            <li><A href="${itemUrl}">${item.name}</A></li>
        </c:if>

    </c:forEach>
    <c:if test="${empty authorizedUser}">
        <li><a href="/shop/login">Login</a></li>
    </c:if>
    <li><a href="/shop/product/list">Product</a></li>
    <li><a href="/shop/main">Main</a></li>
</ul>


<script >
    <%@include file="/WEB-INF/js/navbar-sidenav-initialize.js"%>
</script>
<%--    </c:if>--%>
