element=document.querySelector("article")
function removeCookie(){
    element.remove()
}
arr=[]
newarr=[]
for(var i=1;i<9;i++){
var temperature=document.querySelector("#scal"+i)
    var a=parseInt(temperature.innerText)
    arr[i-1]=(a*1.8)+32
}
for(var i=1;i<9;i++){
    var temperature=document.querySelector("#scal"+i)
        var a=parseInt(temperature.innerText)
        newarr[i-1]=a
}
console.log(arr)
function convert(element){
    console.log(element.value);
    for(var i=1;i<9;i++){
    var temperature=document.querySelector("#scal"+i)
    if(element.value=="F°"){
        temperature.innerText=Math.round( arr[i-1])
    }
    else if(element.value=="C°"){
        temperature.innerText=newarr[i-1]
    }
    }
}
