import React,{useState,useEffect} from 'react'
import axios from 'axios';
import { useParams ,useNavigate } from "react-router-dom";

const Update = () => {
    const[title,setTitle] = useState("")
    const[price,setPrice] = useState(0)
    const[description,setDescription] = useState("")
    const { id } = useParams();
    const navigate = useNavigate()
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/'+id)
        .then(res => {setTitle(res.data.title); setPrice(res.data.price);setDescription(res.data.description)})
        .catch(err => console.log(err))
    },[])
    const handelSubmit = e =>{
        e.preventDefault();
        axios.put('http://localhost:8000/api/product/'+id+'/edit',{
            title,
            price,
            description
        })
        .then(res=>{navigate('/product/new')})
        .catch(err=>console.log(err))
    }
  return (
    <div>
        <form onSubmit={handelSubmit}>
            <p>
                <label> Title : </label>
                <input type='text' onChange={(e)=>setTitle(e.target.value)} value={title}/>
            </p>
            <p>
                <label> Price : </label>
                <input type='text' onChange={(e)=>setPrice(e.target.value)} value={price}/>
            </p>
            <p>
                <label> Description : </label>
                <input type='text' onChange={(e)=>setDescription(e.target.value)} value={description}/>
            </p>
            <input type='submit' />
        </form>
    </div>
  )
}

export default Update