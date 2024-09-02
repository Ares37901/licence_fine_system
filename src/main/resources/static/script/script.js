var darkMode = false;
var largeText = false;
var twoDigitYear = new Date().getFullYear().toString().substr(-2);
var postCodeErrorText;
var expiryDateErrorText;

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
    postCodeErrorText = document.getElementById("postCodeErrorText");
    expiryDateErrorText = document.getElementById("expiryDateErrorText");
    if(postCodeErrorText !== null)
    {
        document.getElementById("postcode").onblur = validateFields;
    }
    if(expiryDateErrorText !== null)
    {
        document.getElementById("expiryDateFirstPart").onblur = validateFields;
        document.getElementById("expiryDateSecondPart").onblur = validateFields;
    }

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
    if(postCodeErrorText !== null){
        if(!(/^([A-Za-z][A-Ha-hJ-Yj-y]?[0-9][A-Za-z0-9]? ?[0-9][A-Za-z]{2}|[Gg][Ii][Rr] ?0[Aa]{2})$/.test(document.getElementById("postcode").value)))
        {
            noErrors = false;
            postCodeErrorText.innerHTML = "Error in postcode.";
        }
        else
        {
            postCodeErrorText.innerHTML = "";
        }
    }
    //check expiry date

    if(expiryDateErrorText !==null){
        var expiryFirstPart = parseInt(document.getElementById("expiryDateFirstPart"));
        var expirySecondPart = parseInt(document.getElementById("expiryDateSecondPart"));
        if(Number.isNaN(expiryFirstPart) || Number.isNan(expirySecondPart))
        {
            noErrors = false;
            expiryDateErrorText.innerHTML = "Expiry date is not a number.";
        }
        else if(expiryFirstPart <1 || expiryFirstPart >12 || expirySecondPart < twoDigitYear)
        {
            noErrors = false;
            expiryDateErrorText.innerHTML = "Expiry date out of bounds.";
        }
        else
        {
            expiryDateErrorText.innerHTML = "";
        }
    }

    return noErrors;
}
function validateForm()
{
    return validateFields();
}