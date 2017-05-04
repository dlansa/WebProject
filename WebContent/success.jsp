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
    <title>Success</title>
</head>
<body>
<div class="intro">
    <div class="form">
        <div class="text">
            Nice:
            <c:out value="${NICE}"/>
            <br><br><a href="hello.html" type="submit" class="btn btn-default">
            <i class="fa fa-sign-in"></i> Back
        </a>
        </div>
    </div>
</div>
<footer>
    <a href="https://github.com/dlansa"><i class="fa fa-github fa-4x" aria-hidden="true"></i></a>
</footer>
</body>
</html>