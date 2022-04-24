import axios from "axios";
import React ,{useEffect,useState} from "react";
import Product from "../component/Product";
import ProductList from "../component/ProductList";
export default () => {
    
    return(
        <div>
            <Product />
            <hr/>
            <h1> All Products </h1>
            <ProductList />
        </div>
    )
}