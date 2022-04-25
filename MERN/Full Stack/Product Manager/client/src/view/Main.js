import axios from "axios";
import React ,{useEffect,useState} from "react";
import Product from "../component/Product";
import ProductList from "../component/ProductList";
export default (props) => {
    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/product/new')
            .then(res=>{
                setProducts(res.data);
                setLoaded(true);
                
            })
            .catch(err => console.error(err));
    },[]);

    
    return(
        <div>
            <Product />
            <hr/>
            <h1> All Products </h1>
             {loaded && <ProductList />}
        </div>
    )
}