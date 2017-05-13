<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Hangman</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/hangman.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/learnforfun.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/js/users.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/hangman.js" />" type="text/javascript">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>

    <script src="<c:url value="/resources/js/angualr-controllers/app.js" />" type="text/javascript">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            background-image: url("<c:url value="/resources/img/img4.jpg" />");
            background-repeat: no-repeat;
            background-size: 1800px;
            color: azure;
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
<body>
<input type="hidden" class="form-control" id = "type" value="${type}">
<input type="hidden" class="form-control" id = "user-id" value="${userID}">
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
                            <c:choose>
                                <c:when test="${notifizer.type!='comment'}">
                                    ${notifizer.notifizer} published a new ${notifizer.type} in a course you are registered in.
                                </c:when>
                                <c:otherwise>
                                    ${notifizer.notifizer} commented on your game.
                                </c:otherwise>
                            </c:choose>

                        </a>
                    </c:forEach>
                </div>
            </li>
            <li><a href="http://localhost:8080/Learn-For-Fun/profileSettings/${type}/${userID}"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/signout/${account.userName}"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<h2>${game.gameName}</h2>
<div class="acidjs-rating-stars">
    <form>
        <input type="radio" name="group-1" id="group-1-0" value="5" onclick="getRate(value)" /><label for="group-1-0"></label><!--
        --><input type="radio" name="group-1" id="group-1-1" value="4" onclick="getRate(value)"  /><label for="group-1-1"></label><!--
        --><input type="radio" name="group-1" id="group-1-2" value="3" onclick="getRate(value)" /><label for="group-1-2"></label><!--
        --><input type="radio" name="group-1" id="group-1-3" value="2" onclick="getRate(value)" /><label for="group-1-3"></label><!--
        --><input type="radio" name="group-1" id="group-1-4"  value="1" onclick="getRate(value)" /><label for="group-1-4"></label>
    </form>
    <script>
        function getRate(input){

        }
    </script>
</div>
<div class="wrapper">
    <br>

    <p>Use the alphabet below to guess the word, or click hint to get a clue. </p>
</div>
<div class="wrapper">
    <div id="buttons">
    </div>
    <input type="hidden" id ="answer" value="${game.answer}">
    <input type="hidden" id ="hangman-hint" value="${game.hint}">

    <p>${game.question} ? </p>
    <div id="hold">
    </div>
    <p id="mylives"></p>
    <p id="clue">Clue :</p>
    <canvas id="stickman">This Text will show if the Browser does NOT support HTML5 Canvas tag</canvas>

    <div class="container">
        <br>
        <button id="hint">Hint</button>
        &nbsp;
        &nbsp;
        &nbsp;
        <button id="reset">Play again</button>
    </div>
</div>


<br>
<br>
</body>
</html>
