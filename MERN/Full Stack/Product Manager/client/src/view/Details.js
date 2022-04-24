import axios from "axios";
import React ,{useEffect,useState} from "react";
import { useParams ,Link ,useNavigate} from "react-router-dom";
import ProductList from "../component/ProductList";
export default (props) => {
    const [product,setProduct] = useState({});
    const [ loaded,setLoaded] = useState(false);
    const { id } = useParams();
    const navigate=useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/'+id)
            .then(res => {setProduct(res.data);setLoaded(true)})
            .catch(err => console.error(err));
    }, []);
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/product/delete/'+productId)
        .then(res => {navigate('/product/new')})
        .catch(err => console.log(err))
    }
    return(
        <div>
            <p>Title: { loaded && product.title}</p>
            <p>Price: { product.price}</p>
            <p>Description: { product.description}</p>
            <Link to = {'/product/'+product._id +'/edit'}>Edit</Link>
            <button onClick={(e)=> {deleteProduct(product._id)}}>Delete</button>
        </div>
    )}