import React,{Component} from 'react';

class PersonCard extends Component{
    constructor(props){
        super(props);
        this.state={
            age:this.props.age
        };
    }
    incremant=() =>{
        this.setState({age: this.state.age+1 })
    }
    render(){
        return(
            <div>
               <h1> {this.props.firstname} , {this.props.lastname}</h1>
               <p>Age : {this.state.age}</p>
               <p>Hair color : {this.props.color}</p>
               <button onClick={this.incremant}>Birthday Button for {this.props.firstname} {this.props.lastname}</button>
            </div>
        );
    }
}
export default PersonCard;