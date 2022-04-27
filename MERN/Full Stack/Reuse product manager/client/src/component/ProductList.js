import React, { useEffect, useState } from 'react'
import axios from 'axios'
import {
    BrowserRouter,
    Link, 
    Route, 
    Routes, 
    Switch
  } from "react-router-dom";
import DeleteButton from './DeleteButton';
const ProductList = (props) => {
    
    const {myProducts , setMyProduct}=props
    const removeFromDom = productid =>{
      setMyProduct(myProducts.filter(product => product._id != productid))
    }
  return (
    <div>
        {myProducts.map((product,inx) =>
        <p key={inx}>
            <Link to ={`/product/${product._id}`}>{product.title}</Link>
            <DeleteButton productID={product._id} successCall={()=> removeFromDom(product._id)}/>
            </p>  )  
        }
    </div>
  )
}

export default ProductList