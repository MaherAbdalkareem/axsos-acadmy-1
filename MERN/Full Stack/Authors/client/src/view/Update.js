import React,{useEffect, useState} from 'react'
import axios from 'axios'
import { useParams,Navigate, useNavigate ,Link} from 'react-router-dom'
import AuthorForm from '../component/AuthorForm'
const Update = (props) => {
    const [author,setAuthor]=useState()
    const [loaded,setLoaded]=useState(false)
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();
    const {id}=useParams();
    useEffect(() => {
        axios.get('http://localhost:8000/author/'+id)
        .then(res => {setAuthor(res.data);setLoaded(true)})
        .catch(err => console.log(err))
    })
    const updateAuthor = newauthor => {
        axios.put('http://localhost:8000/author/'+id+'/edit',newauthor)
        .then(res => {navigate('/')})
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
        <h2>Edit author: </h2>
        { loaded && (<AuthorForm onSubmitProp={updateAuthor} errors={errors} iName={author.name}/>)}
    </div>
  )
}

export default Update