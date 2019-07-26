<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 23.07.2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<u:html title="registration"></u:html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
</head>
<div class="section"></div>
<form method="post" action="/login.html">
    <center>

        <h5 class="indigo-text">Registration</h5>
        <div class="section"></div>
        <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                <form class="col s12" method="post">
                    <div class='row'>
                        <div class='col s12'>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate   ' type='text' name='name' id='email' />
                            <label  for='email'>Enter your email</label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate  ' type='password' name='password' id='password' />
                            <label  for='password'>Enter your password</label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='tel' id='tel' />
                            <label for='tel'>Telephone</label>
                        </div>
                    </div>

                    <br />

                    <p>
                        <label>
                            <input  type="checkbox" class="filled-in indigo"  name="role" value="USER"/>
                            <span>USER</span>
                        </label>
                    </p>

                    <p>
                        <label>
                            <input type="checkbox" class="filled-in"  name="role" value="COURIER"/>
                            <span>COURIER</span>
                        </label>
                    </p>

                    <center>
                        <div class='row'>
                            <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Registration</button>
                        </div>
                    </center>
                    <script>
                        $(document).ready(function(){
                            $('.filled-in').click(function() {
                                $('.filled-in').not(this).prop('checked', false);
                            });
                        });
                    </script>
                </form>
            </div>
        </div>
        <a href="/login.html">Login</a>
    </center>
    <div class="section"></div>
    <div class="section"></div>
</form>

