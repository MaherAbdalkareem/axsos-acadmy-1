import React , {useState,useEffect}from 'react'
import axios from 'axios'
const Form = (props) => {
    const[pokemon,setPokemon]=useState([]);
    const handeler=() =>{
        axios.get('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0').then(response=>{setPokemon(response.data.results)})
    }
  return (
    <div>
        <button onClick={handeler}>Fetch Pokemon</button>
        <div>
                {pokemon.map((pokemon, index)=>{
                    return (<div key={index}>{pokemon.name}</div>)
                })}
                
            </div>
    </div>
  )
}

export default Form