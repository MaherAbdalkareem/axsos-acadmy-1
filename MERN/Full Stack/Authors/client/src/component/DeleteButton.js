import React from 'react'
import axios from 'axios'
import { useParams ,useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table , Button} from 'react-bootstrap'
const DeleteButton = (props) => {
    const {authorID,successCall}=props
    const deleteProduct = ()=>{
        axios.delete('http://localhost:8000/author/delete/'+authorID)
        .then(res => {successCall()})
        .catch(err => console.log(err))
    }
  return (
    <div>
        <Button onClick={deleteProduct}> Delete</Button>
    </div>
  )
}

export default DeleteButton