import React, { useEffect, useState } from 'react'
import TeamForm from '../component/TeamForm'
import {Link, useNavigate} from 'react-router-dom'
import axios from 'axios'
const Add = () => {
  const [team,setTeam]=useState([])
    const [loaded,setLoaded]=useState(false)
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/')
        .then(res => {setTeam(res.data);setLoaded(true)})
        .catch(err => console.log(err))
    })
    const createTeam = teams => {
        axios.post('http://localhost:8000/new',teams)
        .then(res => {setTeam([...team,teams]);setLoaded(true);navigate('/player/list')})
        .catch(err=>{
            const errorResponse = err.response.data.errors; // Get the errors from err.response.data
            const errorArr = []; // Define a temp error array to push the messages in
            for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                errorArr.push(errorResponse[key].message)
            }
            // Set Errors
            setErrors(errorArr);
        })    
    }
  return (
    <div>
        <h1>
        <Link to={'/player/list'}>List</Link> |
        <Link to={'/player/addplayer'}>Add player</Link>
    </h1>
    <TeamForm onSubmitProp={createTeam} errors={errors} iName="" iposition=""/>
</div>
  )
}

export default Add