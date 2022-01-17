
element1=document.querySelector("#user1")
element2=document.querySelector("#user2")
function remove(i){
    if(i==0){
        element1.remove(i)
    }
    else if(i==1){
        element2.remove(i)
    }
}
arr=[2,500]
newarr=[document.querySelector("#num1"),document.querySelector("#num2")]
function myfun(id){
    if(id==0){
    arr[0]--,arr[1]++
    newarr[0].innerHTML=arr[0];
    newarr[1].innerHTML=arr[1]
}
else if(id==1){
    arr[0]--;
    newarr[0].innerHTML=arr[0]
}
}
element4=document.querySelector("#name")
function change(){
    element4.innerHTML=prompt("enter your name")
}