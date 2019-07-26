<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--    <c:if test="${not empty authorizedUser}">--%>
    <nav>
        <div id = "1" class="nav-wrapper indigo ">
            <a href="#" class="brand-logo right А ">Shop</a>
            <ul id="nav-mobile" class="left hide-on-med-and-down indigo ">
                <c:forEach items="${menu}" var="item">
                    <c:url value="${item.url}" var="itemUrl"/>
                    <LI class="item"><A href="${itemUrl}">${item.name}</A></LI>
                </c:forEach>
                  <c:if test="${not empty authorizedUser}">
                      <li><a href="/logout.html">Выход</a></li>
                  </c:if>

                <c:if test="${empty authorizedUser}">
                    <li><a href="/login.html">Login</a></li>
                    <li><a href="/main.html">Главная</a></li>
                </c:if>
                <li><a href="/product/list.html">Продукты</a></li>
                <li><button  class="btn waves-effect waves-light"  onclick="chooseColor()">Set Theme Color
                </button>
                </li>
            </ul>
        </div>
    </nav>
<script>
    function chooseColor() {
        document.getElementById("1").className="nav-wrapper red";
        document.getElementById("nav-mobile").className="left hide-on-med-and-down red";
    }
</script>

<%--    </c:if>--%>
