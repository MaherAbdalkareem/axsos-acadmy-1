import React from 'react'
import { useParams } from "react-router";

const Number = (props) => {
    const {number}=useParams();
    if(isNaN(number)){
  return (
    <div>
        
        <h1>The World is : {number}</h1>
    </div>
  )}
  else{
    return (
        <div>
            
            <h1>The Number is : {number}</h1>
        </div>
      )
  }
}

export default Number