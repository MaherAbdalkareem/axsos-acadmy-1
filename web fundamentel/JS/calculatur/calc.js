var element=document.querySelector("#display")
var arr=[]
var operator = "";
var firstValue = "";
var secondValue = "";
var finalResult = 0;
function press(a){
    if(operator == ""){
        var number=document.querySelector("#num"+a)
        var parsedInt=parseInt(number.innerText)
        element.innerText=parsedInt
        arr.push(parsedInt)
        firstValue = arr.join('');
        element.innerText=firstValue
    }
    
    if(operator != ""){
        
        var number=document.querySelector("#num"+a)
        var parsedInt=parseInt(number.innerText)
        element.innerText=parsedInt
        arr.push(parsedInt)
        secondValue = arr.join('');
        element.innerText=secondValue
    }
    console.log(firstValue, secondValue)
}

function setOP(oper){
    operator=oper;
    document.querySelector("#display").innerText = "0"
    arr = []
}

function clr(){
    arr=[]
    operator = "";
    firstValue = "";
    secondValue = "";
    finalResult = 0;
    element.innerText = "0"
}

function calculate(){
    if(operator == "+"){ // addition operation
        result = parseInt(firstValue) + parseInt(secondValue);
        return element.innerText = result;
    }else if(operator == "-"){ // multiply
        result = parseInt(firstValue) - parseInt(secondValue);
        return element.innerText = result;
    }else if(operator == "*"){
        result = parseInt(firstValue) * parseInt(secondValue);
        return element.innerText = result;
    }else if(operator == "/"){
        result = parseInt(firstValue) / parseInt(secondValue);
        return element.innerText = result;
    }
}
