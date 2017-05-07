window.addEventListener('load', function (){
        var nav = document.getElementById("nav-bar");
        var div = document.getElementsByName("div");
        var coursesID = document.getElementsByName("courseID");
        var type = document.getElementById('type').value;
        var userID = document.getElementById('user-id').value;
        if (type == "teacher") {
            var li1 = document.createElement("li");
            li1.className = "active";
            var a1 = document.createElement("a");
            a1.href = "http://localhost:8080/Learn-For-Fun/profile/" + type + '/' + userID;
            a1.innerHTML = "Home";
            li1.appendChild(a1);
            var li2 = document.createElement("li");
            var a2 = document.createElement("a");
            a2.href = "http://localhost:8080/Learn-For-Fun/showCourses/allCourses/" + type + '/' + userID;
            a2.innerHTML = "Courses";
            li2.appendChild(a2);
            var li3 = document.createElement("li");
            var a3 = document.createElement("a");
            a3.href = "http://localhost:8080/Learn-For-Fun/createCourse/" + type + '/' + userID;
            a3.innerHTML = "Create Course";
            li3.appendChild(a3);
            var li4 = document.createElement("li");
            var a4 = document.createElement("a");
            a4.href = "http://localhost:8080/Learn-For-Fun/showCourses/createdCourses/" + type + '/' + userID;
            a4.innerHTML = "Created Courses";
            li4.appendChild(a4);
            nav.appendChild(li1);
            nav.appendChild(li2);
            nav.appendChild(li3);
            nav.appendChild(li4);

            for (var i = 0; i < div.length; i++) {
                var input = document.createElement("a");
                input.type = "button";
                input.href = "http://localhost:8080/Learn-For-Fun/addGames/" + type + '/' + coursesID[i].value + '/' + userID;
                input.className = "btn btn-danger";
                input.innerHTML = "Add Games";
                div[i].appendChild(input);

            }
        }
        else {
            var li1 = document.createElement("li");
            li1.className = "active";
            var a1 = document.createElement("a");
            a1.href = "http://localhost:8080/Learn-For-Fun/profile/" + type + '/' + userID;
            a1.innerHTML = "Home";
            li1.appendChild(a1);
            var li2 = document.createElement("li");
            var a2 = document.createElement("a");
            a2.href = "http://localhost:8080/Learn-For-Fun/showCourses/allCourses/" + "type" + '/' + userID;
            a2.innerHTML = "Courses";
            li2.appendChild(a2);
            nav.appendChild(li1);
            nav.appendChild(li2);
        }
});
