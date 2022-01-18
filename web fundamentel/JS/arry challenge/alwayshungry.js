function alwaysHungry(arr) {
    var count=0;
    for(var i=0;i<=arr.length-1;i++){
        if(arr[i]=="food"){
            console.log("Yammy")
        }
        else if (arr[i]!="food"){
            count++;
            if(count==arr.length){
                console.log("I'm hungry")
            }
        }
    }
}
   
alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"