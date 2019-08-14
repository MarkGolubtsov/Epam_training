<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 14.08.2019
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="lang" var="value"/>
<u:html title="Create croduct">
    <form method="post" enctype='multipart/form-data' action="/shop/product/create">
        <div class="row">
            <div class="col s6 offset-s3">
                <div class="file-field input-field">
                    <div class="btn indigo">
                        <span><fmt:message key="File" bundle="${value}"/></span>
                        <input type="file" name="file">
                    </div>
                    <div class="file-path-wrapper">
                        <input  class="file-path validate" type="text" pattern="(.*)\.(png|jpeg|jpg)$">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
                <div class='input-field col s6 offset-s3'>
                    <input required pattern="[a-zA-Z ]+" class='validate' type='text' name='name' id="name"/>
                    <label for='name'><fmt:message key="Enter_name_product" bundle="${value}"/></label>
                </div>
        </div>
        <div class="row">
            <div class='input-field col s6 offset-s3'>
                <input required pattern="[a-zA-Z ]+" class='validate' type='text' name='type' id="type"/>
                <label for='type'><fmt:message key="Enter_type" bundle="${value}"/></label>
            </div>
        </div>

        <div class="row">
            <div class='input-field col s6 offset-s3'>
                <input required pattern="[0-9]+" class='validate' type='text' name='cost' id="cost"/>
                <label for='cost'><fmt:message key="Enter_cost" bundle="${value}"/></label>
            </div>
        </div>
        <div class="row">
            <div class="align center">
                <button class="btn waves-effect waves-green indigo"  type="submit"><fmt:message key="Create_Product" bundle="${value}"/><i class="material-icons right">create</i></button>
            </div>

        </div>

        </form>
</u:html>
