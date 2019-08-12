<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- Custom stlylesheet -->

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		<![endif]-->
	<style>
		<%@include file="/WEB-INF/jsp/error/css/style.css"%>
	</style>

</head>

<body>
<script>
	<%@include file="/WEB-INF/js/translate.js"%>
</script>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<c:choose>
					<c:when test="${not empty error}">
						<h2 id="error">${error}</h2>
						<script>
							translateDate($('#error').text(),"#error");
						</script>
					</c:when>
					<c:when test="${not empty pageContext.errorData.requestURI}">
						<h1>404</h1>
					</c:when>
					<c:otherwise>
					<h2 id="Unexpected">Unexpected application error</h2>
						<script>
							translateDate($('#Unexpected').text(),"#Unexpected");
						</script>
					</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
				<c:when test="${not empty error}">
				</c:when>
				<c:when test="${not empty pageContext.errorData.requestURI}">
					<h2 id="Oops">Oops!Page Not Be Found</h2>
					<p id="info">Sorry but the page you are looking for does not exist or is temporarily unavailable</p>
					<script>
						translateDate($('#Oops').text(),"#Oops");
						translateDate($('#info').text(),"#info");
						translateDate($('#homePage').text(),"#homePage");
					</script>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<a id="homePage" href="/shop/main">Back to homepage</a>
			<script>
				translateDate($('#homePage').text(),"#homePage");
			</script>
		</div>
	</div>

</body>

</html>
