<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 24.07.2019
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="Products">
    <script >
        <%@include file="/WEB-INF/js/translate.js"%>
    </script>

    <div class="row">
        <div class="input-field col s3 offset-s4">
            <i class="material-icons prefix">search</i>
            <input  autocomplete="off" class="Serch" id="icon_prefix" type="text" class="validate">
            <label for="icon_prefix"><fmt:message key="Search" bundle="${value}"/></label>
        </div>
    </div>

<div class="row">
    <div class="col s3 offset-s1">
        <div class="row">
            <p>
                <label>
                    <input id="NameSearch" type="checkbox"  class="filled-in"  value="Name"/>
                    <span><fmt:message key="Find_by_Name" bundle="${value}"/></span>
                </label>
            </p>
        </div>
        <div class="row">
            <p>
                <label >
                    <input id="typeSearch" type="checkbox"  class="filled-in"  value="Type"/>
                    <span><fmt:message key="Find_by_Type" bundle="${value}"/></span>
                </label>
            </p>
        </div>
        <div class="row">
            <p>
                <label >
                    <input id="costSearch" type="checkbox"  class="filled-in"  value="Cost"/>
                    <span><fmt:message key="Find_by_Cost" bundle="${value}"/></span>
                </label>
            </p>
        </div>
    </div>


    <div id="Container" class="col s3">
        <c:forEach items="${listProduct}" var="item">
                <div   typeProduct=${item.type} nameProduct="${item.name}" costProduct="${item.cost}" class="card ">
                    <div class="card-image">
                        <c:if test="${ empty item.img_path}">
                            <img src="/img/img2.jpg" alt="Image"/>
                        </c:if>
                        <c:if test="${ not  empty item.img_path}">
                            <img src="/img/${item.img_path}" alt="Image"/>
                        </c:if>
                        <span id="card-title${item.id}"class="card-title"></span>
                        <script>
                            translateDate('${item.name}','#card-title${item.id}');
                        </script>
                        <c:if test="${not (empty authorizedUser) && not (authorizedUser.role!='USER')}">
                            <button onclick="addEventOnButtonAdd(${item.id})" id="butAdd${item.id}" dataProduct="${item.id}" type="submit" class="btn-floating halfway-fab waves-effect waves-green  red"><i class="material-icons">add_shopping_cart</i></button>
                        </c:if>
                    </div>
                    <div class="card-content">
                        <div style="overflow: hidden;">
                            <p style="float: left;"><fmt:message key="Cost" bundle="${value}"/>:</p>
                                <%--                            class--%>
                            <p i style="float: right;">${item.cost}</p>
                        </div>
                        <div style="overflow: hidden;">
                            <p style="float: left;"><fmt:message key="Type" bundle="${value}"/>:</p>
                            <p data="${item.type}"id="type${item.id}" style="float: right;">${item.type}</p>
                            <script>
                                translateDate('${item.type}','#type${item.id}');
                            </script>
                        </div>
                    </div>
                </div>
        </c:forEach>
    </div>

</div>
<script>
    <%@include file="/WEB-INF/js/listProduct.js"%>
</script>
</u:html>