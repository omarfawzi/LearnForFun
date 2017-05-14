app.controller('AccountController', ["$scope", "$http", function ($scope, $http) {
    $scope.signUp = function (valid) {

        if (valid) {
            var firstname = document.getElementById("signUp-firstname").value;
            var email = document.getElementById("signUp-email").value;
            var pass = document.getElementById("signUp-password").value;
            var lastname = document.getElementById("signUp-lastname").value;
            var username = document.getElementById("signUp-username").value;
            var gender = document.getElementById("signUp-gender").value;
            var bdate = document.getElementById("signUp-bdate").value;
            var phone = document.getElementById("signUp-phone").value;
            var type = document.getElementById("type").value;
            var SignUpalert = document.getElementById("SignUp-alert");

            var Info;

            var dat = {
                "password": pass,
                "userName": username,
                "mail": email,
                "phone": phone,
                "firstName": firstname,
                "lastName": lastname,
                "bdate": bdate,
                "gender": gender
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/sign/" + type + '/' + dat.mail + '/' + dat.password + '/' + dat.userName + '/' + dat.phone + '/' + dat.firstName + '/' + dat.lastName + '/' + dat.bdate + '/' + dat.gender;
            if (email != '' && pass != '' && username != '' && firstname != '' && lastname != '' && bdate != '' && gender != '' && phone != '') {
                $http.post(url, dat, config).then(function (response) {
                    if (response.data == -1) {
                        SignUpalert.innerHTML = "userName or email exists in database";
                    }
                    else {
                        SignUpalert.innerHTML = "Signed Up Successfully with id : " + response.data;
                        window.location.href = "http://localhost:8080/Learn-For-Fun/profile/" + type + '/' + response.data;
                    }
                    // alert(response.data.mail + " " + response.data.password + " " + response.data.age + " " + response.data.phone + " " + response.data.userName + " "
                    //     + response.data.firstName + " " + response.data.lastName + " " + response.data.age + " " + response.data.bdate + " " + response.data.gender + " "
                    // );
                }, function (response) {
                });
            }
        }
    };
    $scope.signIn = function (valid) {
        if (valid) {
            var email = document.getElementById("signIn-email").value;
            var Pass = document.getElementById("signIn-password").value;
            var type = document.getElementById("type").value;
            var SignInalert = document.getElementById("SignIn-alert");
            var dat = {
                "mail": email,
                "password": Pass
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/sign/" + type + '/' + dat.mail + '/' + dat.password;
            if (email != '' && Pass != '') {
                $http.post(url, dat, config).then(function (response) {
                    if (response.data == -1) {
                        var em = document.getElementById("signIn-email");
                        em.style.border = "4px solid red";
                        var pass = document.getElementById("signIn-password");
                        pass.style.border = "";
                        SignInalert.innerHTML = "Email does not exist in database";
                        //alert("Email does not exist in database");
                    }
                    else if (response.data == -2) {
                        var em = document.getElementById("signIn-email");
                        em.style.border = "4px solid green";
                        var pass = document.getElementById("signIn-password");
                        pass.style.border = "4px solid red";
                        SignInalert.innerHTML = "Wrong Password";

                        // alert("Right email but wrong password");
                    }
                    else {
                        var em = document.getElementById("signIn-email");
                        em.style.border = "4px solid green";
                        var pass = document.getElementById("signIn-password");
                        pass.style.border = "4px solid green";
                        SignInalert.innerHTML = "Signed-In Successfully";
                        //alert("Login Successfully");
                        //$location.path('http://localhost:8080/Learn-For-Fun/profile/" + type +'/' +response.data');
                        window.location.href = "http://localhost:8080/Learn-For-Fun/profile/" + type + '/' + response.data;
                    }
                    //alert(response.data.mail + " " +response.data.password + " " + response.data.age+ " 3" );
                    //window.location.href = "http://localhost:8080/Learn-For-Fun/";
                }, function (response) {
                });
            }
        }
    }
}]);