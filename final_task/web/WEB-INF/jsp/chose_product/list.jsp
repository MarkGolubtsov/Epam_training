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
<u:html title="Basket"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<div class="row">
    <form class="col s12">
        <div class="row">
            <div class="col s4"></div>
            <div class="input-field col s4">
                <i class="material-icons prefix">search</i>
                <input  autocomplete="off" class="Serch" id="icon_prefix" type="text" class="validate">
                <label for="icon_prefix">Seach</label>
            </div>
        </div>
    </form>
</div>

<div class="row">
    <div class="col s1"></div>
    <div class="col s3">
        <div class="row">
            <p>
                <label>
                    <input id="NameSearch" type="checkbox"  class="filled-in"  value="Name"/>
                    <span>Name</span>
                </label>
            </p>
        </div>
        <div class="row">
            <p>
                <label >
                    <input id="typeSearch" type="checkbox"  class="filled-in"  value="Type"/>
                    <span>Type</span>
                </label>
            </p>
        </div>
        <div class="row">
            <p>
                <label >
                    <input id="costSearch" type="checkbox"  class="filled-in"  value="Cost"/>
                    <span>Cost</span>
                </label>
            </p>
        </div>
    </div>
    <div id="Container" class="col s5">
        <c:forEach items="${listChoseProduct}" var="item">
            <div   typeProduct=${item.product.type} nameProduct="${item.product.name}" costProduct="${item.product.cost}" class="card ">
                <div class="card-image">
                    <c:if test="${ empty item.product.img_path}">
                        <img src="/img/img2.jpg" alt="Image"/>
                    </c:if>
                    <c:if test="${ not  empty item.product.img_path}">
                        <img src="/img/${item.product.img_path}" alt="Image"/>
                    </c:if>
                    <span  class="card-title">${item.product.name}</span>
                    <c:if test="${not empty authorizedUser}">
                        <button id="butAdd${item.product.id}" dataProduct="${item.product.id}" type="submit" class="btn-floating halfway-fab waves-effect waves-green  red"><i class="material-icons">add</i></button>
                        <script>
                            $("#butAdd${item.product.id}").on("click",function() {
                                $.ajax({
                                    type:"POST",
                                    url : '/shop/addInCart',
                                    data : {
                                        idProduct :(this).getAttribute("dataProduct")
                                    },
                                    success:function (response) {
                                        console.log(response);
                                        $("#count${item.product.id}").text(response);
                                    }
                                    // error: error()
                                });
                            });
                        </script>
                    </c:if>
                </div>
                <div class="card-content">
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
        </c:forEach>
    </div>

</div>
<script>
    <%@include file="/WEB-INF/js/listProduct.js"%>
</script>