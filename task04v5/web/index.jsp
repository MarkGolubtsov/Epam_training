<%@ page import="java.util.List" %>
<%@ page import="entity.Flower" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Task04</title>
  </head>
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  <body>
  <div class="row" >
    <div class="col 6s">
      <form  method="post" enctype="multipart/form-data">
        <input  type="file" name="file" />
        <button class="btn waves-effect waves-light"  type="submit" >
          <i class="material-icons right">send</i>
        </button>
      </form>
    </div>
  </div>
  </body>
</html>
