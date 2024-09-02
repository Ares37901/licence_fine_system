var darkMode = false;
var largeText = false;
var twoDigitYear = new Date().getFullYear().toString().substr(-2);

function loadSettings()
{
    var keyValuePairs = document.cookie.split(';');
    for(var i=0;i<keyValuePairs.length;i++){
        var keyAndValue = keyValuePairs[i].split('=');
        if(keyAndValue[0].trim() == "darkMode"){
            if(keyAndValue[1] == "true"){
                setDarkMode(true);
            }
            else{
                darkMode = false;
            }
        }
        else if(keyAndValue[0].trim() == "largeText"){
            if(keyAndValue[1] == "true"){
                setLargeText(true);
            }
            else{
                largeText = false;
            }
        }
    }
    //add event listeners for input boxes
    document.getElementById("postcode").onblur = validateFields;
    document.getElementById("expiryDateFirstPart").onblur = validateFields;
    document.getElementById("expiryDateSecondPart").onblur = validateFields;
}

function darkModeToggle()
{
    if(!darkMode){
        setDarkMode(true);
    }
    else{
        setDarkMode(false);
    }
}
function largeTextToggle()
{
    if(!largeText){
        setLargeText(true);
    }
    else{
        setLargeText(false);
    }
}
function setDarkMode(on)
{
    if(on){
        document.body.style.color = "white";
        document.body.style.backgroundColor = "black";
        document.cookie="darkMode=true";
        darkMode=true;
    }
    
    else{
        document.body.style.color = "black";
        document.body.style.backgroundColor = "white";
        document.cookie="darkMode=false";
        darkMode=false;
    }
}
function setLargeText(on)
{
    if(on){
        document.body.style.fontSize = "x-large";
        document.cookie="largeText=true";
        largeText=true;
    }
    else{
        document.body.style.fontSize = "medium";
        document.cookie="largeText=false";
        largeText=false;
    }
}
function validateFields()
{
    var noErrors =true;
    //check postcode
    if(!(/^([A-Za-z][A-Ha-hJ-Yj-y]?[0-9][A-Za-z0-9]? ?[0-9][A-Za-z]{2}|[Gg][Ii][Rr] ?0[Aa]{2})$/.test(document.getElementById("postcode").value)))
    {
        noErrors = false;
        document.getElementById("postCodeErrorText").innerHTML = "Error in postcode.";
    }
    else
    {
        document.getElementById("postCodeErrorText").innerHTML = "";
    }
    //check expiry date
    var expiryFirstPart = parseInt(document.getElementById("expiryDateFirstPart"));
    var expirySecondPart = parseInt(document.getElementById("expiryDateSecondPart"));
    if(expiryFirstPart <1 || expiryFirstPart >12 || expirySecondPart < twoDigitYear)
    {
        noErrors = false;
        document.getElementById("expiryDateErrorText").innerHTML = "Expiry date of of bounds.";
    }
    else
    {
        document.getElementById("expiryDateErrorText").innerHTML = "";
    }

    return noErrors;
}
function validateForm()
{
    return validateFields();
}