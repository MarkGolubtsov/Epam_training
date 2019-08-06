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
    <div  id="Container" class=" container col s3">
        <c:forEach items="${listChoseProduct}" var="item">
            <div choseProductId="${item.id}"  countProduct="${item.count}" typeProduct=${item.product.type} nameProduct="${item.product.name}" costProduct="${item.product.cost}" id="card${item.product.id}" class="section">
            <div  class="card">

                <div class="card-image">
                    <c:if test="${ empty item.product.img_path}">
                        <img src="/img/img2.jpg" alt="Image"/>
                    </c:if>
                    <c:if test="${ not  empty item.product.img_path}">
                        <img src="/img/${item.product.img_path}" alt="Image"/>
                    </c:if>
                    <span  class="card-title">${item.product.name}</span>
                    <c:if test="${not empty authorizedUser}">
                        <button onclick="addEventOnButtonAddInCart(${item.product.id},${item.id})" id="butAdd${item.product.id}" class="btn-floating halfway-fab waves-effect waves-green  red"><i class="material-icons">exposure_plus_1</i></button>
                    </c:if>
                </div>
                <div class="card-content">
                    <c:if test="${not empty authorizedUser}">
                            <button onclick="addEventOnButtonRemoveInCart(${item.product.id},${item.id})" id="butRemove${item.product.id}"  type="submit" class="btn-floating halfway-fab waves-effect waves-green blue"><i class="material-icons">exposure_neg_1</i></button>
                    </c:if>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Count:</p>
                        <p id="count${item.product.id}" style=" size:8px;float: right;">${item.count}</p>
                    </div>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Cost:</p>
                            <%--                            class--%>
                        <p class="cost" style="float: right;">${item.product.cost}</p>
                    </div>
                    <div style="overflow: hidden;">
                        <p style="float: left;">Type:</p>
                        <p  style="float: right;">${item.product.type}</p>
                    </div>
                    <div >
                            <label>
                                <input  data_id_chose_product="${item.id}" countProduct="${item.count}" typeProduct=${item.product.type} nameProduct="${item.product.name}" costProduct="${item.product.cost}"  data_id_product="${item.product.id}" id="choseProduct${item.id}" type="checkbox" />
                                <span>Add in Order</span>
                            </label>
                    </div>
                </div>
            </div>
            </div>
        </c:forEach>
    </div>

    <div  class="col s6 offset-s3" >
        <div class="container col s6">
            <div class="z-depth-1 grey lighten-4 row" style=" display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
                <form>
                    <div class='row'>
                        <div >
                            <p  style="float: left;">Final cost:</p>
                                <%--                            class--%>
                            <p id="OrderCost" style="float: right;">0</p>
                        </div>
                    </div>

                    <div  class='row'>
                        <p>Delivery: </p>
                        <p>
                            <label>
                                <input class="left" checked id="type_delivery_pickup" type="checkbox" />
                                <span>PickUP</span>
                            </label>
                        </p>
                        <p>
                            <label>
                                <input class="right" id="type_delivery_courier" type="checkbox" />
                                <span>COURIER</span>
                            </label>
                        </p>
                        <br/>
                        <p>Type Pay:</p>
                        <p>
                            <label>
                                <input checked id="type_pay_cash" type="checkbox" />
                                <span>CASH</span>
                            </label>
                        </p>

                        <p>
                            <label>
                                <input  id="type_pay_cashless" type="checkbox" />
                                <span>CASHLESS</span>
                            </label>
                        </p>
                    </div>
                    <br />
                    <center>
                        <div class='row'>
                            <a onclick="setUser(${userId})" class="waves-effect waves-light btn-smal"><i class="material-icons" >add_circle</i>Create Order</a>
                        </div>
                    </center>
                </form>
            </div>
        </div>

    </div>

</div>
<script>
    <%@include file="/WEB-INF/js/listProduct.js"%>
</script>

</u:html>