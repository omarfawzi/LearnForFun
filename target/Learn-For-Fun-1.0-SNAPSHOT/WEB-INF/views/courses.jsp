<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Courses</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/learnforfun.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/angualr-controllers/app.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/angualr-controllers/CourseController.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/users.js" />" type="text/javascript">
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
        .navbar, .panel {
            box-shadow: 0px 2px 20px 2px black;
            background: transparent;
            border-color: transparent;
        }

        .navbar li {
            color: #000
        }

        .container, .panel-footer {
            background: transparent;
            border-color: transparent;
        }
    </style>

</head>
<body data-ng-app="app" data-ng-controller="CourseController">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080/Learn-For-Fun/profile/${type}/${userID}">
                <img src="<c:url value="/resources/img/logo8.png" />" style="margin-top: -16px; height: 50px">
            </a>
        </div>
        <ul class="nav navbar-nav" id="nav-bar">
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="javascript:void(0)" class="dropbtn" style="cursor: pointer;">
                    <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
                    <span class="badge">${number}</span>
                </a>
                <div class="dropdown-content">
                    <c:forEach items="${notifizers}" var="notifizer">
                        <a href="http://localhost:8080/Learn-For-Fun/showGames/teacher/${userID}/${notifizer.courseID}">
                            <span class="glyphicon glyphicon-user" style="color: black"></span>
                                ${notifizer.notifizer} published a new ${notifizer.type} in a course you are registered in.</a>
                    </c:forEach>
                </div>
            </li>
            <li><a href="http://localhost:8080/Learn-For-Fun/profileSettings/${type}/${userID}"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/signout/${account.userName}"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<br>
<br>
<br>
<br>
<input type="hidden" class="form-control" id = "type" value="${type}">
<input type="hidden" class="form-control" id = "user-id" value="${userID}">

<div class="container" id="try">
    <div class="row">
<c:forEach items="${registeredCourses}" var="ids">
    <input type="hidden" name="registeredCourse" value="${ids}">
</c:forEach>
    <c:forEach items="${courses}" var="course">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">-</a>
                            <i class="fa fa-coffee"></i>
                            <p style="color: black" id="${course.ID}">Waiting for input...</p>
                        </div>
                        Course Name
                        <input type="text" class="form-control" id="course-name" name="coursename"readonly value="${course.name}">
                    </div>
                    <div class="form-group">
                        Course Description
                        <textarea class="form-control" rows="5" id="course-description" name="courseDescription"readonly>${course.description}
                        </textarea>
                    </div>
                </div>
                <div class="panel-footer" name="div" data-ng-controller="CourseController" id="main">
                    <a type="button" class="btn btn-primary" href="http://localhost:8080/Learn-For-Fun/showGames/${type}/${userID}/${course.ID}">Show Games</a>
                    <input type="hidden" name="courseID" value="${course.ID}">
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
</div>
<br>
<br>
</body>
</html>
