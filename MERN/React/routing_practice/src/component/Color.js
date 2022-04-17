import React from 'react'
import { useParams } from "react-router";

const Color = (props) => {
    const {word}=useParams();
    const {color}=useParams();
    const {backColor}=useParams();
  return (
    <div>
        <h1 style={{backgroundColor:color, color:backColor}}>The word is : {word}</h1>
    </div>
  )
}

export default Color