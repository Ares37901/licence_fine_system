var darkMode = false;
var largeText = false;
var twoDigitYear = new Date().getFullYear().toString().substr(-2);
var postCodeErrorText;
var expiryDateErrorText;
var creditCardErrorText;

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
    creditCardErrorText = document.getElementById("creditCardErrorText");
    securityCodeErrorText = document.getElementById("securityCodeErrorText");
    fineErrorText = document.getElementById("fineErrorText");
    referenceErrorText = document.getElementById("referenceErrorText");

    if(postCodeErrorText !== null)
    {
        document.getElementById("postcode").onblur = validateFields;
    }
    if(expiryDateErrorText !== null)
    {
        document.getElementById("expiryDateFirstPart").onblur = validateFields;
        document.getElementById("expiryDateSecondPart").onblur = validateFields;
    }
    if(creditCardErrorText !== null)
    {
        document.getElementById("creditCardNumber").onblur = validateFields;
    }
    if(securityCodeErrorText !== null)
    {
        document.getElementById("securityCode").onblur = validateFields;
    }
    if(fineErrorText !== null)
    {
        document.getElementById("fine").onblur = validateFields;
    }
    if(referenceErrorText !== null)
    {
        document.getElementById("reference").onblur = validateFields;
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
        document.body.style.backgroundColor = "#202020";
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
        var expiryFirstPartText = document.getElementById("expiryDateFirstPart").value;
        var expiryFirstPart = parseInt(expiryFirstPartText);
        var expirySecondPartText = document.getElementById("expiryDateSecondPart").value
        var expirySecondPart = parseInt(expirySecondPartText);
        if((!(/^\d+$/.test(expiryFirstPartText))) || (!(/^\d+$/.test(expirySecondPartText))))
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
    //check credit/debit card
    if(creditCardErrorText !== null){
        var creditCardText = document.getElementById("creditCardNumber").value.replaceAll(" ", "");
        //var creditCardNumbers = parseInt(creditCardText);
        if(!(/^\d+$/.test(creditCardText)))
        {
            noErrors = false;
            creditCardErrorText.innerHTML = "Credit card needs to be numbers only."
        }
        else
        {
            creditCardErrorText.innerHTML = "";
        }

    }

    //check security code
    if(securityCodeErrorText !== null){
        var securityCodeText = document.getElementById("securityCode").value;
        if(!(/^\d+$/.test(securityCodeText)))
        {
            noErrors = false;
            securityCodeErrorText.innerHTML = "Security code is not a number";
        }
        else if(securityCodeText.length !== 3)
        {
            noErrors = false;
            securityCodeErrorText.innerHTML = "Security code must be three digits long";
        }
        else
        {
            securityCodeErrorText.innerHTML = "";
        }

    }

    //check fine
    if(fineErrorText !== null){
        var fineText = document.getElementById("fine").value;
        var fineNumbers = parseFloat(fineText);
        if(Number.isNaN(fineNumbers) || (!(/^\d+\.?\d*$/.test(fineText))))
        {
            noErrors = false;
            fineErrorText.innerHTML = "Amount must be a number";
        }
        else
        {
            fineErrorText.innerHTML = "";
        }
    }

    //check reference
    if(referenceErrorText !== null){
        var referenceText = document.getElementById("reference").value;
        if(referenceText.length !== 9)
        {
            noErrors=false;
            referenceErrorText.innerHTML = "Reference must be 9 letters long";
        }
        else
        {
            referenceErrorText.innerHTML = "";
        }
    }

    return noErrors;
}
function validateForm()
{
    return validateFields();
}