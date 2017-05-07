<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Sign</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript">
    </script>
   <script src="<c:url value="/resources/js/angualr-controllers/app.js" />" type="text/javascript">
    </script>
    <script src="<c:url value="/resources/js/angualr-controllers/AccountController.js" />" type="text/javascript">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <style>
        body {
            background-image: url("<c:url value="/resources/img/img4.jpg" />");
            background-repeat: no-repeat;
            background-size: 1800px;
            color:azure;
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
<body data-ng-app="app" data-ng-controller="AccountController">
<header>
    <center>
        <a href="http://localhost:8080/Learn-For-Fun/">
            <img src="<c:url value="/resources/img/logo8.png" />">
        </a>
    </center>
</header>
<div class="container">
    <div class="page-header">
        <h1>${type} Account</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="panel-group">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <center>
                            <h4 class="panel-title" style="color: black">
                                <a data-toggle="collapse" href="#collapse1">Sign In</a>
                            </h4>
                        </center>
                    </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <br>
                            <div class="alert alert-info alert-dismissable">
                                <a class="panel-close close" data-dismiss="alert">-</a>
                                <i class="fa fa-coffee"></i>
                                <p style="color: black" id="SignIn-alert">Waiting for input....</p>
                            </div>
                            <form role="form" name="signInForm">
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input type="email" class="form-control" id="signIn-email" name="email" required>
                                    <input type="hidden" class="form-control" id = "type" value="${type}">
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="password" class="form-control" id="signIn-password" name="password" required>
                                </div>

                                <center>
                                    <button class="btn btn-danger" data-ng-click="signIn(signInForm.$valid)">Submit
                                    </button>
                                </center>
                                <br>
                            </form>
                        </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel-group">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <center>
                            <h4 class="panel-title" style="color: black">
                                <a data-toggle="collapse" href="#collapse2">Sign Up</a>
                            </h4>
                        </center>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <br>
                        <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">-</a>
                            <i class="fa fa-coffee"></i>
                            <p style="color: black" id="SignUp-alert">Waiting for input....</p>
                        </div>
                            <form role="form" name="signUpForm">
                                <div class="form-group">
                                    <label>First Name:</label>
                                    <input type="text" class="form-control" id="signUp-firstname" name="firstname"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label>Last Name:</label>
                                    <input type="text" class="form-control" id="signUp-lastname" name="lastname"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label>Username:</label>
                                    <input type="text" class="form-control" id="signUp-username" name="username"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label>Email address:</label>
                                    <input type="email" class="form-control" id="signUp-email" name="email" required>
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="password" class="form-control" id="signUp-password" name="password"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password:</label>
                                    <input type="password" class="form-control" id="signUp-confirm_password"
                                           name="confirm_password" oninput="check(this)" required>
                                </div>
                                <div class="form-group">
                                    <label>Phone:</label>
                                    <input type="tel" id="signUp-phone" class="form-control" name="bdate">
                                </div>
                                <div class="form-group">
                                    <label>Gender:</label>
                                    <select id="signUp-gender" name="gender" class="form-control">
                                        <option value="male" class="form-control"> male</option>
                                        <option value="female" class="form-control"> female</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Birthdate:</label>
                                    <input type="date" id="signUp-bdate" class="form-control" name="bdate">
                                </div>
                                <center>
                                    <button class="btn btn-danger" data-ng-click="signUp(signUpForm.$valid)">Submit
                                    </button>
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
