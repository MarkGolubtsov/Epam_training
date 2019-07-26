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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<u:html title="Products"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<div class="section"></div>
<div class="section"></div>
<div class="section"></div>
<div class="row">
    <form class="col s12">
        <div class="row">
            <div class="col s4"></div>
            <div class="input-field col s4">
                <i class="material-icons prefix">mode_edit</i>
                <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
                <label for="icon_prefix2">Search</label>
            </div>
            <div>
            <input type="text" id="1"/>
            </div>
        </div>
    </form>
</div>

<div class="row">
    <div class="col s4"></div>
        <div class="col s1">
                <p>
                    <label >
                        <input id="NameSearch" type="checkbox"  class="filled-in"  value="Name"/>
                        <span>Name</span>
                    </label>
                </p>
        </div>
        <div class="col s1">
                <p>
                    <label >
                        <input id="costSearch" type="checkbox"  class="filled-in"  value="Cost"/>
                        <span>Cost</span>
                    </label>
                </p>
        </div>
        <div class="col s1">
            <button id="searchButton" class="btn waves-effect waves-light indigo" type="submit" name="action">Search
                <i class="material-icons right">send</i>
            </button>
        </div>
    <script>
        $(document).ready(function(){
            $('.filled-in').click(function() {
                $('.filled-in').not(this).prop('checked', false);
            });

            $("#searchButton").click(function(){
                var nameSearch =$("#NameSearch").is(':checked');
                var costSearch =$("#costSearch").is(':checked');
                if (nameSearch || costSearch) {
                    var search=$("input").val();
                    var all = [];
                    if (nameSearch)
                    $(".card-title").each(function () {
                        all.push($(this).text())
                    });

                    if(costSearch) {
                        $(".costProduct").each(function () {
                            all.push($(this).text());
                        });
                    }
                    var nothideCard = [];
                    var i=0;
                    alert(search);
                    all.forEach(function (element) {
                        var collator = new Intl.Collator();
                        if (collator.compare(search,element)==0) {
                            nothideCard.push(i);
                        }
                        i++;
                    })

                    var j = 0;

                    $(".card").each(function () {
                        if (nothideCard.indexOf(j) != -1)
                        {
                            $(this).hide();
                        }
                        j++;
                    })
                }
                });
        });

    </script>
</div>
<div class="row">
    <c:forEach items="${listProduct}" var="item">
        <div class="col s12">
            <div class="col s4"></div>
        <div class="col s4 ">
                <div class="card ">
                    <div class="card-image">
                        <c:if test="${ empty item.img_path}">
                            <img src="/img/img2.jpg" alt="Image"/>
                        </c:if>
                        <c:if test="${ not  empty item.img_path}">
                            <img src="/img/${item.img_path}" alt="Image"/>
                        </c:if>
                        <span class="card-title">${item.name}</span>
                        <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
                    </div>
                    <div></div>
                    <div class="card-content">

                        <div style="overflow: hidden;">
                            <p style="float: left;">Cost:</p>
                            <p class="costProduct" style="float: right;">${item.cost}</p>
                        </div>
                        <div style="overflow: hidden;">
                            <p style="float: left;">Type:</p>
                            <p  class="TypeProduct"style="float: right;">${item.type}</p>
                        </div>
                    </div>
                </div>
        </div>
        <div class="col s4"></div>
        </div>
    </c:forEach>
</div>
