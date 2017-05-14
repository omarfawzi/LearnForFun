<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>HomePage</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/learnforfun.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/homePageResponsive.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            background-image: url("<c:url value="/resources/img/img4.jpg" />");
            background-repeat: no-repeat;
            background-size: 1800px;
        }
    </style>
</head>
<body>
<header>
    <center>
        <a href="http://localhost:8080/Learn-For-Fun">
            <img src="<c:url value="/resources/img/logo8.png" />">
        </a>
    </center>
</header>

<form action="sign/student/" method="post">
    <button type="submit" value="student" class="hoverbutton"><span>Student </span></button>
</form>
<form action="sign/teacher/" method="post">
    <button type="submit" value="teacher" class="hoverbutton"><span>Teacher </span></button>
</form>
</body>
</html>
