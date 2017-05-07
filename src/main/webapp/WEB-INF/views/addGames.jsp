<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Add Game</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/learnforfun.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/users.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/angualr-controllers/app.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/angualr-controllers/GameController.js" />" type="text/javascript">
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
<body data-ng-app="app" data-ng-controller="GameController">
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
            <li><a href="http://localhost:8080/Learn-For-Fun/profileSettings/${type}/${userID}"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>
            <li><a href="http://localhost:8080/Learn-For-Fun/signout/${account.userName}"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<input type="hidden" class="form-control" id = "type" value="${type}">
<input type="hidden" class="form-control" id = "user-id" value="${userID}">
<input type="hidden" class="form-control" id="courseID" value="${courseID}">
<div class="container">
    <div class="page-header">
        <h1>Create game</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <center><h4>True Or False</h4></center>

                    <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">-</a>
                            <i class="fa fa-coffee"></i>
                            <p style="color: black" id="alert-TF">Add Game....</p>
                        </div>
                        <form name="TForm" role="form">
                            <div class="form-group">
                                Add Name
                                <input type="text" id="TF-Name" class="form-control" placeholder="Enter Game Name"
                                       required>
                                <br>
                                Add Question
                                <input type="text" id="TF-Question" class="form-control" placeholder="Enter question"
                                       required>
                                <br>
                                Add Answer
                                <br>
                                <input type="radio" class="form-check-input" name="TFChoices" value="true">
                                <label><p style="display: inline;"> True </p></label>
                                <input type="radio" class="form-check-input" name="TFChoices" value="false">
                                <label><p style="display: inline;"> False </p></label>
                            </div>
                            <center>
                                <input type="button" value="Add Game" class="btn btn-danger" data-ng-click="addTF(TForm.$valid)">
                            </center>
                        </form>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-body">
                        <center><h4>MCQ</h4></center>
                        <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">-</a>
                            <i class="fa fa-coffee"></i>
                            <p style="color: black" id="alert-MCQ">Add Game....</p>
                        </div>
                        <form  name="MCQForm" role="form">
                            <div class="form-group">
                                Add Name
                                <input type="text" id="MCQ-Name" class="form-control" placeholder="Enter Game Name"
                                       required>
                                <br>
                                Question 1
                                <input type="text" id ="MCQ-Question" class="form-control" placeholder="Enter question"
                                       required>
                                <br>
                                Choices
                                <br>

                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            1.
                                            <input class="form-control" name="MCQChoices" type="text"
                                                   placeholder="Choice 1">
                                        </div>
                                        <div class="col-sm-6">
                                            2.
                                            <input class="form-control" name="MCQChoices" type="text"
                                                   placeholder="Choice 2">
                                        </div>
                                        <br>
                                        <br>
                                        <div class="col-sm-6">
                                            3.
                                            <input class="form-control" name="MCQChoices" type="text"
                                                   placeholder="Choice 3" required>
                                        </div>
                                        <div class="col-sm-6">
                                            4.
                                            <input class="form-control" name="MCQChoices" type="text"
                                                   placeholder="Choice 4" required>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                Right Choice number
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <input class="form-control" id="MCQRightChoice" type="number" min="1" max="4" step="1"
                                                   placeholder="Enter right choice number" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <center>
                                <input type="button" value="Add Game" class="btn btn-danger" data-ng-click="addMCQ(MCQForm.$valid)">
                            </center>
                        </form>
                </div>
            </div>
            </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <center><h4>Hangman</h4></center>
                    <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">-</a>
                            <i class="fa fa-coffee"></i>
                            <p style="color: black" id="alert-Hangman">Add Game....</p>
                        </div>
                        <form name="HangmanForm" role="form">
                            <div class="form-group">
                                Add Name
                                <input type="text" id="Hangman-Name" class="form-control" placeholder="Enter Game Name"
                                       required>
                                <br>
                                Add Question
                                <input type="text" id="Hangman-Question" class="form-control" placeholder="Enter question"
                                       required>
                                <br>
                                Add Answer
                                <br>
                                <input type="text" id="Hangman-Answer" class="form-control" placeholder="Enter answer"
                                       required>
                                <br>
                                Add Hint
                                <input type="text" id="Hangman-Hint" class="form-control" placeholder="Enter answer"
                                       required>
                            </div>
                            <center>
                                <input type="button" value="Add Game" class="btn btn-danger" data-ng-click="addHangman(HangmanForm.$valid)">
                            </center>
                        </form>
                </div>
            </div>
        </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
