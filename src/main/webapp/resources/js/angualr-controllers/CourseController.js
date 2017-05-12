app.controller('CourseController', ["$scope", "$http", function ($scope, $http) {
    $scope.addCourse = function (valid) {
        if (valid) {
            var courseName = document.getElementById("course-name").value;
            var courseDescription = document.getElementById("course-description").value;
            var alert = document.getElementById("alert");
            var type = document.getElementById("type").value;
            var id = document.getElementById("user-id").value;
            var dat = {
                "description": courseDescription,
                "name": courseName,
                "userID": id
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/createCourse/" + dat.userID + '/' + dat.name + '/' + dat.description;
            if (courseName != '' && courseDescription != '') {
                $http.post(url, dat, config).then(function (response) {
                    if (response.data != -1)
                        alert.innerHTML = "Course Added with id : " + response.data;
                    else
                        alert.innerHTML = "Course Name must be unique this name already exists the database";
                }, function (response) {
                    alert.innerHTML = "Error";
                });
            }
        }
    };
    $scope.registerCourse = function (userID,courseID) {
        var alert =  document.getElementById(courseID);
        var dat = {
            "ID": courseID,
            "userID": userID
        };
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var url = "http://localhost:8080/Learn-For-Fun/registerCourse/"+ userID+'/' + courseID ;
        $http.post(url, dat, config).then(function (response) {
            if (response.data == true)
                alert.innerHTML = "Course Registered Successfully";
            else
                alert.innerHTML ="Error";
        }, function (response) {
            alert.innerHTML = "Error";
        });
    };
    $scope.unregisterCourse = function (userID,courseID) {
        var alert =  document.getElementById(courseID);
        var dat = {
            "ID": courseID,
            "userID": userID
        };
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var url = "http://localhost:8080/Learn-For-Fun/unregisterCourse/"+ userID+'/' + courseID ;
        $http.post(url, dat, config).then(function (response) {
            if (response.data == true)
                alert.innerHTML = "Course UN-Registered Successfully";
            else
                alert.innerHTML ="Error";
        }, function (response) {
            alert.innerHTML = "Error";
        });
    }
}]);