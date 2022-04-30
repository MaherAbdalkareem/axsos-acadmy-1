import React, { useEffect,useState } from 'react'
import axios from 'axios'
import {
    Link,
} from "react-router-dom";
const ProductList = (props) => {
    const {products, setProducts} = props;
    const removeFromDom = productId => {
        setProducts(products.filter(product => product._id !== productId));
    }
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/product/delete/'+productId)
        .then(res =>  removeFromDom(productId))
        .catch(err => console.log(err))
    }
    
  return (
    <div>
        {products.map((product,inx) =>
        <p key={inx}>
            <Link to ={`/product/${product._id}`}>{product.title}</Link>
            <button onClick={(e)=> {deleteProduct(product._id)}} >Delete</button>
            </p>  )  
        }
    </div>
  )
}

export default ProductList