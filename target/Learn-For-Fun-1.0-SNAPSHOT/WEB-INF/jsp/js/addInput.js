var counter = 1;
var limit = 3;
var counterMCQ = 1;
var limitMCQ = 2;
function addInput(divName) {
    if (counter === limit) {
        alert('You have reached the limit of adding ' + counter + ' inputs');
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.innerHTML = "<hr>Question" + (counter + 1) + "<br><input type='text' name='TFInputs[]' class='form-control' placeholder='Enter question' required>";
        newdiv.innerHTML += "<br>Answer :" + "<br><input type='radio' class='form-check-input' name='TFAnswers[]' value='true'> <label><p style='display: inline;'> True </p></label> <input type='radio' class='form-check-input' name='myAnswers[]' value='false'> <label><p style='display: inline;'> False </p></label>";
        document.getElementById(divName).appendChild(newdiv);
        counter++;
    }
}
function addInputMCQ(divName) {
    if (counterMCQ == limitMCQ) {
        alert('You have reached the limit of adding ' + counterMCQ + ' inputs');
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.innerHTML = "<hr>Question" + (counter + 1) + "<br><input type='text' name='MCQInputs[]' class='form-control' placeholder='Enter question' required><br>";
        newdiv.innerHTML += "Choice <br> <div class='row'> <div class='form-group'> <div class='col-sm-6'> <input class='form-control' name='MCQChoices[]'  type='text' placeholder='Choice 1'> </div> <div class='col-sm-6'> <input class='form-control' name='MCQChoices[]'  type='text' placeholder='Choice 2'> </div> <br> <br> <div class='col-sm-6'> <input class='form-control' name='MCQChoices[]'  type='text' placeholder='Choice 3'> </div> <div class='col-sm-6'> <input class='form-control' name='MCQChoices[]'  type='text' placeholder='Choice 4'> </div> </div> </div> <br>Right Choice : <div class='row'> <div class='form-group'> <div class='col-sm-12'> <input class='form-control' name='MCQRightChoice'  type='text' placeholder='Right Choice'> </div> </div> </div>";
        document.getElementById(divName).appendChild(newdiv);
        counterMCQ++;
    }
}

