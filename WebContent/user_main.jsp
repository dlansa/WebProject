<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>User page</title>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">
</head>
<body>
	<form class="logout" action="hello.html">
		<button type="submit" class="btn btn-default">
			<i class="fa fa-sign-in"></i> Logout
		</button>
	</form>
	<header> </header>

	<div class="container-fluid">
		<h1>The last added books are:</h1>
		<div class="row">
			<c:forEach items="${books}" var="i">
				<div class="col-xs-6 col-lg-4">
					<div class="thumbnail">
						<img src="${i.getPicURL()}">
						<div class="caption">
							<a href="${i.getUrl()}">
								<h3>
									<c:out value="${i.getTitle()}" />
								</h3>
							</a>
							<p>
								<c:out value="${i.getAuthor()}" />
							</p>
							<h4>
								<c:out value="${i.getPrice()}" />
							</h4>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<footer>
		<a href="https://github.com/dlansa"><i class="fa fa-github fa-4x" aria-hidden="true"></i></a>
	</footer>
	<script src="css/salvattore.min.js"></script>
</body>
</html>