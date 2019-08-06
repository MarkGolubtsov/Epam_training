<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--    <c:if test="${not empty authorizedUser}">--%>
<c:url value="/shop/logout" var="logOut"/>
<c:url value="/shop/login" var="login"/>
<c:url value="/shop/product/list" var="listProduct"/>
<c:url value="/shop/main" var="main"/>
    <nav class="indigo">
            <a href="#" class="brand-logo right  ">Shop</a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul id="nav-wrapper" class="left hide-on-med-and-down indigo ">
                <c:if test="${not empty authorizedUser}">
                    <li ><a href="${logOut}"><i class="material-icons"> exit_to_app</i></a></li>
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
                </c:if>

                <c:if test="${empty authorizedUser}">
                    <li><a href="${login}">Login</a></li>
                </c:if>
                <li><a href="${listProduct}">Product</a></li>
                <li><a href="${main}">Main</a></li>
            </ul>
        </div>
    </nav>


<ul class="sidenav" id="mobile-demo">
    <c:if test="${not empty authorizedUser}">
        <li ><a href="${logOut}"><i class="material-icons"> exit_to_app</i></a></li>
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
    </c:if>

    <c:if test="${empty authorizedUser}">
        <li><a href="${login}">Login</a></li>
    </c:if>
    <li><a href="${listProduct}">Product</a></li>
    <li><a href="${main}">Main</a></li>
</ul>


<script >
    <%@include file="/WEB-INF/js/navbar-sidenav-initialize.js"%>
</script>
<%--    </c:if>--%>
