import React, { useEffect,useState } from 'react'
import axios from 'axios'
import {
    Link,
} from "react-router-dom";
const ProductList = (props) => {
    const [product,setProduct] = useState([])
    const { removeFromDom } = props;
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/new')
        .then(response => setProduct(response.data))
        .catch(err => console.log(err))   
    },[])
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/product/delete/'+productId)
        .then(res =>  {removeFromDom(productId)})
        .catch(err => console.log(err))
    }
  return (
    <div>
        {product.map((product,inx) =>
        <p key={inx}>
            <Link to ={`/product/${product._id}`}>{product.title}</Link>
            <button onClick={(e)=> {deleteProduct(product._id)}}>Delete</button>
            </p>  )  
        }
    </div>
  )
}

export default ProductList