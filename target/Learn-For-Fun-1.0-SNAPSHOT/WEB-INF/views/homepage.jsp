<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>HomePage</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/learnforfun.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/learnforfun.js" />" type="text/javascript">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/npm.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/addInput.js" />" language="Javascript" type="text/javascript">
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
        <a href="/">
            <img src="<c:url value="/resources/img/logo8.png" />">
        </a>
    </center>
</header>
<form action="Sign" method="get">
    <button type="submit" value="teacher" class="hoverbutton"><span>Teacher </span></button>
    <button type="submit" value="student" class="hoverbutton"><span>Student </span></button>
</form>
</body>
</html>
