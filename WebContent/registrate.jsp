<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <title>Sing up</title>
</head>
<body>
<div class="intro">
    <form class="form" action="MainServlet" method="POST">
        <div class="text">
            <h4><input name="action" type="hidden" value="regstr"/>
                <i class="fa fa-user-o"></i> Login
                <input type="text" class="form-control" value="" name="login"/><br>
                <i class="fa fa-lock"></i> Password
                <input type="password" class="form-control" value="" name="pass"/><br>
                <i class="fa fa-lock"></i> Repeat password
                <input type="password" class="form-control" value="" name="pass2"/><br>
                <button type="submit" class="btn btn-default">
                    <i class="fa fa-user-plus" aria-hidden="true"></i> Sign up
                </button>
                <a href="hello.html" class="btn btn-default">
                        <i class="fa fa-sign-in"></i> Back
                </a>
            </h4>
        </div>
    </form>
</div>
<footer>
    <a href="https://github.com/dlansa"><i class="fa fa-github fa-4x" aria-hidden="true"></i></a>
</footer>
</body>
</html>