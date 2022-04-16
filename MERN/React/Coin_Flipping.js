function tossCoin() {
    return Math.random() > 0.5 ? "heads" : "tails";
}
function fiveHeads() {
    let  headsCount=0;
    let attempts = 0;
    return new Promise( (resolve, reject) => {
        while(headsCount < 5) {
            attempts++;
            if(attempts>100){
                reject("attemps > 100 ")
            }
        let result = tossCoin();
        if(result === "heads") {
            headsCount++;
        } else {
            headsCount = 0;
        }
        
    }
    resolve("it toke "+attempts)
    
    });
}
fiveHeads()
    .then( res => console.log(res) )
    .catch( err => console.log(err) );
console.log( "When does this run now?" );