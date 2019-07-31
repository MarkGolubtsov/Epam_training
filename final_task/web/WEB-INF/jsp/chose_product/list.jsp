<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 27.07.2019
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<u:html title="Basket">
<div class="row">
    <div class="col s1 "></div>
    <div id="Container" class="col s3">
        <c:forEach items="${listChoseProduct}" var="item">
            <div id="card${item.product.id}" class="section">
            <div typeProduct=${item.product.type} nameProduct="${item.product.name}" costProduct="${item.product.cost}" class="card">
                <div class="card-image">
                    <c:if test="${ empty item.product.img_path}">
                        <img src="/img/img2.jpg" alt="Image"/>
                    </c:if>
                    <c:if test="${ not  empty item.product.img_path}">
                        <img src="/img/${item.product.img_path}" alt="Image"/>
                    </c:if>
                    <span  class="card-title">${item.product.name}</span>
                    <c:if test="${not empty authorizedUser}">
                        <button onclick="addEventOnButtonAddInCart(${item.product.id})" id="butAdd${item.product.id}" class="btn-floating halfway-fab waves-effect waves-green  red"><i class="material-icons">exposure_plus_1</i></button>
                    </c:if>
                </div>
                <div class="card-content">
                    <c:if test="${not empty authorizedUser}">
                        <div>
                            <button onclick="addEventOnButtonRemoveInCart(${item.product.id},${item.id})" id="butRemove${item.product.id}"  type="submit" class="btn-floating halfway-fab waves-effect waves-green blue"><i class="material-icons">exposure_neg_1</i></button>
                        </div>
                        <script>
                        </script>
                    </c:if>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Cost:</p>
                            <%--                            class--%>
                        <p i style="float: right;">${item.product.cost}</p>
                    </div>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Type:</p>
                        <p  style="float: right;">${item.product.type}</p>
                    </div>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Count:</p>
                        <p id="count${item.product.id}" style="float: right;">${item.count}</p>
                    </div>
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