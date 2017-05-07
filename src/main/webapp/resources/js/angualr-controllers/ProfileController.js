app.controller('ProfileController', ["$scope", "$http", function ($scope, $http) {
    $scope.update = function (valid) {
        if (valid) {
            var firstname = document.getElementById("user-firstname").value;
            var lastname = document.getElementById("user-lastname").value;
            var gender = document.getElementById("user-gender").value;
            var pass = document.getElementById("user-password").value;
            var bdate = document.getElementById("user-bdate").value;
            var phone = document.getElementById("user-phone").value;
            var type = document.getElementById("type").value;
            var id = document.getElementById("user-id").value;
            var alert = document.getElementById("alert");
            var mail = document.getElementById("user-email").value;

            var dat = {
                "password": pass,
                "phone": phone,
                "firstName": firstname,
                "lastName": lastname,
                "bDate": bdate,
                "gender": gender,
                "userID": id,
                "mail": mail
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/profileSettings/update/" + type + '/' + dat.userID + '/' + dat.mail + '/' + dat.password + '/' + dat.phone + '/' + dat.firstName + '/' + dat.lastName + '/' + dat.bDate + '/' + dat.gender;
            if (pass != '' && firstname != '' && lastname != '' && bdate != '' && gender != '' && phone != '' && mail != '') {
                $http.post(url, dat, config).then(function (response) {
                    if (response.data == false) {
                        alert.innerHTML = "Nothing Changed";
                    }
                    else {
                        alert.innerHTML = "Profile Updated";
                    }
                    // alert(response.data.mail + " " + response.data.password + " " + response.data.age + " " + response.data.phone + " " + response.data.userName + " "
                    //     + response.data.firstName + " " + response.data.lastName + " " + response.data.age + " " + response.data.bdate + " " + response.data.gender + " "
                    // );
                }, function (response) {
                    alert.innerHTML = "Error";
                });
            }
        }
    };
}]);