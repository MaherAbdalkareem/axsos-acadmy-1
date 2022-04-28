import React, { useEffect, useState } from 'react'
import AuthorForm from '../component/AuthorForm'
import {Link , useNavigate} from 'react-router-dom'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table , Button , Row , Col} from 'react-bootstrap'
const Add = () => {
    const [author,setAuthor]=useState([])
    const [loaded,setLoaded]=useState(false)
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/')
        .then(res => {setAuthor(res.data);setLoaded(true)})
        .catch(err => console.log(err))
    })
    const createAuthor = authors => {
        axios.post('http://localhost:8000/new',authors)
        .then(res => {setAuthor([...author,authors]);setLoaded(true);navigate('/')})
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
        <h1>Favorite Author</h1>
        <Link to={`/`}>Home</Link>
        <h2>Add a new author: </h2>
        <AuthorForm onSubmitProp={createAuthor} errors={errors} iName=""/>
    </div>
  )
}

export default Add