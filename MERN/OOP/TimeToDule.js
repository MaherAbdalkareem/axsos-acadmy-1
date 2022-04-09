class Card{
    constructor(name,cost){
        this.cost = cost;
        this.name = name;
    }
}

class Unit extends Card{
    constructor(name,cost,power,resillience){
        super(name ,cost);
        this.power=power;   
        this.resillience = resillience;
    }
    attack(target){
        if(target instanceof Unit){
            target.power -= this.power;
        } else{
            throw new Error("Target must be a unit!");
        }
    }

    showStats() {
        console.log("power :" + this.power, "resillience :" + this.resillience);
      }
}
    


class Effect extends Card {
    constructor(name,cost,text,stat,magnitude){
        super(name ,cost);
        this.text = text;
        this.stat= stat;
        this.magnitude = magnitude;
    }
    play(target){
        if(target instanceof Unit){
            if(this.stat = "power"){
                target.power += this.magnitude;
            }else if(this.stat = "resilience"){
                target.res += this.magnitude;
            }
        }
    }
}
const unit1 = new Unit("Red Belt Ninja",3,4,4);
const unit2 = new Unit("Black Belt Ninja",4,5,4);

const effect1 = new Effect("Hard Algorithm",2,"increase target's resilience by 3","resillience",+3)
effect1.play(unit1);
const effect2 = new Effect("Unhandled Promise Rejection",1  ,"reduce target's resilience by 2","resillience",-2)
effect2.play(unit1);
const effect3 = new Effect("Pair Programming",3,"increase target's power by 2","power",+2)

unit1.attack(unit2);
unit1.showStats();