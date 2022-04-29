import React from 'react'
import axios from 'axios'
import { useParams ,useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table , Button} from 'react-bootstrap'
const DeleteButton = (props) => {
    const {teamID,successCall}=props
    const deleteProduct = ()=>{
        axios.delete('http://localhost:8000/team/delete/'+teamID)
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