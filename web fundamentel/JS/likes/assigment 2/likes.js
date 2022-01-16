var like = [9, 12, 9];
var newarr = [
    document.querySelector("#like1"),
    document.querySelector("#like2"),
    document.querySelector("#like3")
];

function likes(id) {
    like[id]++;
    newarr[id].innerHTML = like[id] ;
}