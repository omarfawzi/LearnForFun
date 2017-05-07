<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Create Game</title>
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

        .navbar, .panel {
            box-shadow: 0px 2px 20px 2px black;
            background: transparent;
            border-color: transparent;
        }

        .btn {
            box-shadow: 0px 2px 20px 2px black;
            background: darkgray;
            border-color: darkgray;
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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <img src="<c:url value="/resources/img/logo8.png" />" style="margin-top: -16px; height: 50px">
            </a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Courses</a></li>
            <li><a href="#">Create Course</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        </ul>
    </div>
</nav>
<br>

<div class="container">
    <div class="page-header">
        <h1>Create game</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse1">True & False</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <br>
                        <form method="GET" action="createGame.jsp">
                            <div class="form-group" id="dynamicInput">
                                Question 1
                                <input type="text" name="TFInputs[]" class="form-control" placeholder="Enter question"
                                       required>
                                <br>
                                Answer :
                                <br>
                                <input type="radio" class="form-check-input" name="TFAnswers[]" value="true">
                                <label><p style="display: inline;"> True </p></label>
                                <input type="radio" class="form-check-input" name="TFAnswers[]" value="false">
                                <label><p style="display: inline;"> False </p></label>
                            </div>
                            <center>
                                <button type="button" class="btn btn-primary" onClick="addInput('dynamicInput');">Add
                                    another question
                                </button>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse2">MCQ</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <br>
                        <form method="GET" action="createGame.jsp">
                            <div class="form-group" id="dynamicInput2">
                                Question 1
                                <input type="text" name="MCQInputs[]" class="form-control" placeholder="Enter question"
                                       required>
                                <br>
                                Choices :
                                <br>
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <input class="form-control" name="MCQChoices[]" type="text"
                                                   placeholder="Choice 1">
                                        </div>
                                        <div class="col-sm-6">
                                            <input class="form-control" name="MCQChoices[]" type="text"
                                                   placeholder="Choice 2">
                                        </div>
                                        <br>
                                        <br>
                                        <div class="col-sm-6">
                                            <input class="form-control" name="MCQChoices[]" type="text"
                                                   placeholder="Choice 3">
                                        </div>
                                        <div class="col-sm-6">
                                            <input class="form-control" name="MCQChoices[]" type="text"
                                                   placeholder="Choice 4">
                                        </div>
                                    </div>
                                </div>
                                <br>
                                Right Choice :
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <input class="form-control" name="MCQRightChoice" type="text"
                                                   placeholder="Right Choice">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <center>
                                <button type="button" class="btn btn-primary" onClick="addInputMCQ('dynamicInput2');">
                                    Add another question
                                </button>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse3">Run Code</a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item" src="http://www.ideone.com"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>
