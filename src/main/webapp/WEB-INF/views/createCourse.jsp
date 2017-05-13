<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Create Course</title>
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
    <script>
        function empty(){
            document.getElementById("course-description").value="";
            document.getElementById("course-name").value="";
            document.getElementById("alert").innerHTML="Add Course....";
        }
    </script>
</head>
<body data-ng-app="app" data-ng-controller="CourseController">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080/Learn-For-Fun/profile/${type}/${userID}">
                <img src="<c:url value="/resources/img/logo8.png" />" style="margin-top: -16px; height: 50px">
            </a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/Learn-For-Fun/profile/${type}/${userID}">Home</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/showCourses/allCourses/${type}/${userID}">Courses</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/createCourse/${type}/${userID}">Create Course</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/showCourses/createdCourses/${type}/${userID}">Created Courses</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="javascript:void(0)" class="dropbtn" style="cursor: pointer;">
                    <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
                    <span class="badge">${number}</span>
                </a>
                <div class="dropdown-content">
                    <c:forEach items="${notifizers}" var="notifizer">
                        <a href="http://localhost:8080/Learn-For-Fun/showCourses/allCourses/teacher/${notifizer.second}">
                            <span class="glyphicon glyphicon-user" style="color: black"></span>
                                ${notifizer.first} published a new game in a course you are registered in.</a>
                        <hr>
                    </c:forEach>
                </div>
            </li>
            <li><a href="http://localhost:8080/Learn-For-Fun/profileSettings/${type}/${userID}"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/signout/${account.userName}"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="page-header">
        <h1>Create Course</h1>
    </div>
</div>
<div class="container">
    <form role="form" name="courseForm">
        <div class="alert alert-info alert-dismissable">
            <a class="panel-close close" data-dismiss="alert">-</a>
            <i class="fa fa-coffee"></i>
            <p style="color: black" id="alert">Add Course....</p>
        </div>
        <div class="form-group">
            CourseName
            <input type="text" class="form-control" id="course-name" name="coursename" placeholder="Enter Course Name" required>
            <input type="hidden" class="form-control" id = "type" value="${type}">
            <input type="hidden" class="form-control" id = "user-id" value="${userID}">
        </div>
        <div class="form-group">
            Course Description
            <textarea class="form-control" rows="5" id="course-description" name="courseDescription" placeholder="Description"></textarea>
        </div>
        <input type="button" value="Add Course" class="btn btn-danger" data-ng-click="addCourse(courseForm.$valid)">
    </form>
</div>
<br>
<br>
</body>
</html>
