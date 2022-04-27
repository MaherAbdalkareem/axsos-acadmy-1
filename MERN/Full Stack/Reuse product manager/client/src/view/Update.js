import React, { useEffect, useState } from 'react'
import ProductForm from '../component/ProductForm'
import axios from 'axios'
import { useParams,Navigate, useNavigate } from 'react-router-dom'
import DeleteButton from '../component/DeleteButton'

const Update = () => {
    const [product,setProduct]=useState()
    const [loaded,setLoaded]=useState(false)
    const {id}=useParams();
    const navigate=useNavigate()
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/'+id)
        .then(res => {setProduct(res.data);setLoaded(true)})
        .catch(err => console.log(err))
    })
    const updateProduct = pro => {
        axios.put('http://localhost:8000/api/product/'+id+'/edit',pro)
        .then(res => {navigate('/product')})
        .catch(err => console.log(err))
    }
  return (
    <div>
        { loaded && (<>
        <ProductForm onSubmitProp={updateProduct} iTitle={product.title} iPrice={product.price} iDescreption={product.description}/>
        <DeleteButton productID={product._id} successCall={() => {navigate('/product')}}/>
        </>)}
    </div>
  )
}

export default Update