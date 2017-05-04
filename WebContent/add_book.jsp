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
    <title>Creating new book</title>
</head>
<body>
<div class="intro">
    <form class="form" action="MainServlet" method="POST">
        <div class="text" style="top: 13%;">
            <h4><input name="action" type="hidden" value="addBook">
                Title <input type="text" class="form-control" value="" name="title"/>
                Author <input type="text" class="form-control" value="" name="author"/>
                Price <input type="text" class="form-control" value="" name="price"/>
                Picture <input type="text" class="form-control" value="" name="picture"/>
                Link <input type="text" class="form-control" value="" name="link"/><br>
                <button class="btn btn-default">
                    <i class="fa fa-book" aria-hidden="true"></i> Submit
                </button>
                <a href="admin_main.jsp" class="btn btn-default">
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