<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="no-js" lang="" data-ng-app="app">
<head>
    <title>${type} Profile</title>
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
    <script src="<c:url value="/resources/js/angualr-controllers/ProfileController.js" />" type="text/javascript">
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
    <script language='javascript' type='text/javascript'>
        function check(input) {
            if (input.value != document.getElementById('signUp-password').value) {
                input.setCustomValidity('Password Must be Matching.');
            } else {
                // input is valid -- reset the error message
                input.setCustomValidity('');
            }
        }
    </script>

</head>
<body data-ng-app="app" data-ng-controller="ProfileController">
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
                                ${notifizer.notifizer} published a new ${notifizer.type} in a course you are registered
                            in.</a>
                    </c:forEach>
                </div>
            </li>
            <li><a href="http://localhost:8080/Learn-For-Fun/profileSettings/${type}/${userID}"><span
                    class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/signout/${account.userName}"><span
                    class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1>Personal info</h1>
    <hr>
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                <h6>Upload a different photo...</h6>

                <input type="file" class="form-control">
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">-</a>
                <i class="fa fa-coffee"></i>
                <p style="color: black" id="alert">Waiting for update....</p>
            </div>
            <form class="form-horizontal" role="form" name="updateForm">
                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" id="user-firstname" value="${account.firstName}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" id="user-lastname" value="${account.lastName}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" id="user-email" value="${account.mail}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Gender:</label>
                    <div class="col-lg-8">
                        <div class="ui-select">
                            <select id="user-gender" class="form-control" value="${account.gender}">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Phone:</label>
                    <div class="col-md-8">
                        <input class="form-control" id="user-phone" type="text" value="${account.phone}">
                        <input type="hidden" class="form-control" id="type" value="${type}">
                        <input type="hidden" class="form-control" id="user-id" value="${userID}">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Birthdate:</label>
                    <div class="col-md-8">
                        <input type="date" id="user-bdate" class="form-control" name="bdate" value="${account.BDate}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Password:</label>
                    <div class="col-md-8">
                        <input class="form-control" id="user-password" type="password" value="${account.password}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Confirm Password:</label>
                    <div class="col-md-8">
                        <input class="form-control" id="user-confirm_password" type="password" oninput="check(this)"
                               value="${account.password}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="button" class="btn btn-primary" value="Save Changes"
                               data-ng-click="update(updateForm.$valid)">
                        <span></span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>
