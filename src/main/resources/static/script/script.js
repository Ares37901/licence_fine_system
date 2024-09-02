var darkMode = false;
var largeText = false;

function loadSettings()
{
    var keyValuePairs = document.cookie.split(';');
    for(var i=0;i<keyValuePairs.length;i++){
        var keyAndValue = keyValuePairs[i].split('=');
        if(keyAndValue[0] == "darkMode"){
            if(keyAndValue[1] == "true"){
                setDarkMode(true);
            }
            else{
                darkMode = false;
            }
        }
        else if(keyAndValue[0] == "largeText"){
            if(keyAndValue[1] == "true"){
                setLargeText(true);
            }
            else{
                largeText = false;
            }
        }
    }
    //add event listeners for input boxes
    document.getElementById("darkModeToggle").onclick = darkModeToggle;
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