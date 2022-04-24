import axios from "axios";
import React ,{useEffect,useState} from "react";
import { useParams } from "react-router-dom";
import ProductList from "../component/ProductList";
export default () => {
    const [product,setProduct] = useState({});
    const [ loaded,setLoaded] = useState(false);
    const { id } = useParams();
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/'+id)
            .then(res => {setProduct(res.data);setLoaded(true)})
            .catch(err => console.error(err));
    }, []);
    return(
        <div>
            <p>Title: { loaded && product.title}</p>
            <p>Price: { product.price}</p>
            <p>Description: { product.description}</p>
        </div>
    )}