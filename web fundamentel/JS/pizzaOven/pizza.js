function pizzaOven(crustType,sauceType,cheeses,toppings){
    var pizza={};
    pizza.crustType=crustType;
    pizza.sauceType=sauceType;
    pizza.cheeses=cheeses;
    pizza.toppings=toppings;
    return pizza
}
var y=pizzaOven("deep dish","traditional",["mozzarella"],["pepproni","sausage"])
console.log(y)
var x=pizzaOven("hand tossed","marinara",["mozzarella", "feta"],["mushrooms", "olives", "onions"])
console.log(x)
var crustType =[
    "deep dish",
    "hand tossed",
    "thin",
    "gluten free"
]
var sauceType =[
    "traditional",
    "marinara",
    "bbq",
    "meyo"
];
var cheese =[
    "mozzarella",
    "cheddar",
    "feta",
    "swiss cheese",
    "parmesan"
];
var toppings =[
    "pepperoni",
    "sausage",
    "corn",
    "bell peppers",
    "mushrooms"
];
function randomRange(max, min) {
    return Math.floor(Math.random() * max - min) + min;
}

function randomPick(arr) {
    var i = Math.floor(arr.length * Math.random());
    return arr[i];
}

function randomPizza() {
    var pizza = {};
    pizza.crustType = randomPick(crustType);
    pizza.sauceType = randomPick(sauceType);
    pizza.cheeses = [];
    pizza.toppings = [];
    for(var i=0; i<randomRange(4, 1); i++) {
        pizza.cheeses.push(randomPick(cheese));
    }
    for(var i=0; i<randomRange(4, 0); i++) {
        pizza.toppings.push(randomPick(toppings));
    }
    return pizza;
}

console.log(randomPizza());