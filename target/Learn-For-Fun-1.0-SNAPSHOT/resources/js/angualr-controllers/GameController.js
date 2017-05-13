app.controller('GameController', ["$scope", "$http", function ($scope, $http) {
    $scope.addTF = function (valid) {
        if (valid) {
            var gameName = document.getElementById("TF-Name").value;
            var gameQuestion = document.getElementById("TF-Question").value;
            var gameChoices = document.getElementsByName("TFChoices");
            var answer = !!gameChoices[0].checked;
            var type = document.getElementById("type").value;
            var id = document.getElementById("user-id").value;
            var courseID = document.getElementById("courseID").value;
            var alert = document.getElementById("alert-TF");
            var dat = {
                "question": gameQuestion,
                "gameName": gameName,
                "courseID": courseID,
                "answer": answer
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/addGames/" + dat.courseID + '/' + dat.gameName + '/' + dat.question + '/' + dat.answer;
            $http.post(url, dat, config).then(function (response) {
                if (response.data)
                    alert.innerHTML = "Game Added ";
                else
                    alert.innerHTML = "Game Name must be unique this name already exists the database";
            }, function (response) {
                alert.innerHTML = "Error";
            });
        }
    };
    $scope.addMCQ = function (valid) {
        if (valid) {
            var gameName = document.getElementById("MCQ-Name").value;
            var gameQuestion = document.getElementById("MCQ-Question").value;
            var gameChoices = document.getElementsByName("MCQChoices");
            var answer = document.getElementById("MCQRightChoice").value;
            var type = document.getElementById("type").value;
            var id = document.getElementById("user-id").value;
            var courseID = document.getElementById("courseID").value;
            var alert = document.getElementById("alert-MCQ");
            var dat = {
                "question": gameQuestion,
                "gameName": gameName,
                "courseID": courseID,
                "answer": answer,
                "choice1": gameChoices[0].value,
                "choice2": gameChoices[1].value,
                "choice3": gameChoices[2].value,
                "choice4": gameChoices[3].value
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/addGames/" + dat.courseID + '/' + dat.gameName + '/' + dat.question + '/' + dat.answer + '/' + dat.choice1 + '/' + dat.choice2 + '/' + dat.choice3 + '/' + dat.choice4;
            $http.post(url, dat, config).then(function (response) {
                if (response.data)
                    alert.innerHTML = "Game Added ";
                else
                    alert.innerHTML = "Game Name must be unique this name already exists the database";
            }, function (response) {
                alert.innerHTML = "Error";
            });
        }
    };
    $scope.addHangman = function (valid) {
        if (valid) {
            var gameName = document.getElementById("Hangman-Name").value;
            var gameQuestion = document.getElementById("Hangman-Question").value;
            var gameAnswer = document.getElementById("Hangman-Answer").value;
            var gameHint = document.getElementById("Hangman-Hint").value;
            var alert = document.getElementById("alert-Hangman");
            var type = document.getElementById("type").value;
            var id = document.getElementById("user-id").value;
            var courseID = document.getElementById("courseID").value;
            var dat = {
                "question": gameQuestion,
                "gameName": gameName,
                "courseID": courseID,
                "answer": gameAnswer,
                "hint": gameHint
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };
            var url = "http://localhost:8080/Learn-For-Fun/addGames/" + dat.courseID + '/' + dat.gameName + '/' + dat.question + '/' + dat.answer + '/' + dat.hint;
            $http.post(url, dat, config).then(function (response) {
                if (response.data)
                    alert.innerHTML = "Game Added ";
                else
                    alert.innerHTML = "Game Name must be unique this name already exists the database";
            }, function (response) {
                alert.innerHTML = "Error";
            });
        }
    };
    $scope.deleteTFGame = function (gameID) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var url = "http://localhost:8080/Learn-For-Fun/deleteTF/"+gameID;
        $http.post(url, null, config).then(function (response) {
            window.alert("Game deleted");
            window.location.reload();
        }, function (response) {
            window.alert("Fatal Error");
        });
    };
    $scope.deleteMCQGame = function (gameID) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var url = "http://localhost:8080/Learn-For-Fun/deleteMCQ/"+gameID;
        $http.post(url, null, config).then(function (response) {
            window.alert("Game deleted");
            window.location.reload();
        }, function (response) {
            window.alert("Fatal Error");
        });
    };
    $scope.deleteHangMan = function (gameID) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var url = "http://localhost:8080/Learn-For-Fun/deleteHangMan/"+gameID;
        $http.post(url, null, config).then(function (response) {
            window.alert("Game deleted");
            window.location.reload();
        }, function (response) {
            window.alert("Fatal Error");
        });
    };
    $scope.comment = function (type,userID,gameID,courseID) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };

        var comment ;
        var alert ;
        var place ;
        if (type == "TF") {
            alert = document.getElementById(gameID + ".alertTF");
            place =  document.getElementById("tfComment" + gameID);
        }
        else if (type == "MCQ"){
            alert = document.getElementById(gameID + ".MCQalert");
            place =  document.getElementById("MCQComment" + gameID);
        }
        else {
            alert = document.getElementById(gameID + ".Hangmanalert");
            place =  document.getElementById("HangmanComment" + gameID);
        }
        comment=place.value;
        var dat = {
            "userID":userID,
            "gameID":gameID,
            "courseID":courseID,
            "Comment":comment
        };

        var url ;
        if (type == "TF")
            url = "http://localhost:8080/Learn-For-Fun/addCommentTF/"+userID+"/"+gameID + "/"+courseID +"/"+comment;
        else if (type == "MCQ")
            url = "http://localhost:8080/Learn-For-Fun/addCommentMCQ/"+userID+"/"+gameID + "/"+courseID +"/"+comment;
        else
            url = "http://localhost:8080/Learn-For-Fun/addCommentHangman/"+userID+"/"+gameID + "/"+courseID +"/"+comment;
        if (comment!= "") {
            $http.post(url, dat, config).then(function (response) {
                alert.innerHTML = "Comment added";
                place.value ="";
            }, function (response) {
                alert.innerHTML = "Fatal Error";
            });
        }
        else{
            alert.innerHTML = "You should enter a valid comment";
        }
    }

}]);