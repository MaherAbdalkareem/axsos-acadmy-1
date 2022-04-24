import React, { useEffect,useState } from 'react'
import axios from 'axios'
import {
    Link,
} from "react-router-dom";
const ProductList = (props) => {
    const [product,setProduct] = useState([])
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/new')
        .then(response => setProduct(response.data))
        .catch(err => console.log(err))   
    },[])
  return (
    <div>
        {product.map((product,inx) =>
        <p key={inx}>
            <Link to ={`/product/${product._id}`}>{product.title}</Link></p>  )  
        }
    </div>
  )
}

export default ProductList