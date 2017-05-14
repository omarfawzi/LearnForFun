<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>404</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- //web font -->
    <style>
        body {
            background-image: url("<c:url value="/resources/img/img4.jpg" />");
            background-repeat: no-repeat;
            background-size: 1800px;
        }
    </style>
</head>
<body>
<!-- main -->
<br>
<header>
    <center>
        <a href="${homepage}">
            <img src="<c:url value="/resources/img/logo8.png" />">
        </a>
    </center>
</header>
<div class="agileits-main">
    <div class="agileinfo-row">
        <div class="agileinfo-row">
            <div class="w3layouts-errortext">
                <h2><span>4</span> <span>0</span> <span>4</span></h2>
                <h3>Sorry! The page you are looking could not be found <br><a href="${homepage}">Go to Home Page</a>
                </h3>
            </div>
        </div>
    </div>
</div>
</body>
</html>
