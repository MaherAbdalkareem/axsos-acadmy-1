class Ninja{
    constructor(name){
        this.name=name;
        this.health=50;
        this.speed=3;
        this.strength=3;
    }
    sayName(){
        console.log(`${this.name}`)
        
    }
    showStats(){
        console.log(`Name : ${ this.name } ,Health: ${this.health} ,Speed:  ${this.speed} ,Strength: ${this.strength}`)
    }
    drinkSake(){
        this.health +=10;
    }
}
class Sensei extends Ninja{
    constructor(name){
        super(name)
        this.wisdom=10;
    }
    speakWisdom(){
        console.log('What one programmer can do in one month, two programmers can do in two months.');
    }
}
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();