<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--    <c:if test="${not empty authorizedUser}">--%>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo right">Logo</a>
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <c:forEach items="${menu}" var="item">
                    <c:url value="${item.url}" var="itemUrl"/>
                    <LI class="item"><A href="${itemUrl}">${item.name}</A></LI>
                </c:forEach>
                <c:if test="${empty authorizedUser}">
                    <li><a href="/login.html">Login</a></li>
                    <li><a href="/main.html">Главная</a></li>
                </c:if>
                <li><a href="product/list.html">Продукты</a></li>
            </ul>
        </div>
    </nav>

<%--    </c:if>--%>
