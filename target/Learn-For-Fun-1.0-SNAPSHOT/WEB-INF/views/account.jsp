<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
    <title>Sign</title>
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

        .navbar, .panel, .panel-heading {
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
<header>
    <center>
        <a href="">
            <img src="<c:url value="/resources/img/logo8.png" />">
        </a>
    </center>
</header>
<div class="container">
    <div class="page-header">
        <h1>User Account</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <center>
                            <h4 class="panel-title" style="color: black">
                                <a data-toggle="collapse" href="#collapse1">Sign In</a>
                            </h4>
                        </center>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <br>
                        <form role="form" action="#" method="get">
                            <div class="form-group">
                                <label>Email:</label>
                                <input type="email" class="form-control" name="email">
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                            <center>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <center>
                            <h4 class="panel-title" style="color: black">
                                <a data-toggle="collapse" href="#collapse2">Sign Up</a>
                            </h4>
                        </center>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <br>
                        <form role="form" action="#">
                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" class="form-control" name="username
">
                            </div>
                            <div class="form-group">
                                <label>Email address:</label>
                                <input type="email" class="form-control" name="email">
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="form-group">
                                <label>Gender:</label>
                                <select name="gender" class="form-control">
                                    <option value="male" class="form-control"> male</option>
                                    <option value="female" class="form-control"> female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Birthdate:</label>
                                <input type="date" class="form-control" name="bdate">

                            </div>
                            <center>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
