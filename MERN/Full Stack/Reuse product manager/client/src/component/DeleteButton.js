import React from 'react'
import axios from 'axios'
import { useParams ,useNavigate } from "react-router-dom";
const DeleteButton = (props) => {
    const {productID,successCall}=props
    const deleteProduct = ()=>{
        axios.delete('http://localhost:8000/api/product/delete/'+productID)
        .then(res => {successCall()})
    }
  return (
    <div>
        <button onClick={deleteProduct}> Delete</button>
    </div>
  )
}

export default DeleteButton