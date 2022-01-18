function fibonacciArray(n) {
    var fibArr = [0, 1];
    for(var i=2;i<n;i++){
        fibArr[i]=fibArr[i-1]+fibArr[i-2]
    }
    return fibArr;
}
   
var result = fibonacciArray(20);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]