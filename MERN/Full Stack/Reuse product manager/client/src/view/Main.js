
import React, { useEffect, useState } from 'react';
import ProductForm from '../component/ProductForm';
import axios from 'axios';
import ProductList from '../component/ProductList';

const Main = (props) => {
    const [products,setProduct] = useState([])
    const[loaded,setLoaded]=useState(false)
    useEffect(() => {
      axios.get('http://localhost:8000/api/product/new')
      .then(res => {setProduct(res.data);setLoaded(true);console.log(res.data)})
      .catch(err => console.log(err))
  },[])
    const createProduct = product => {
      axios.post('http://localhost:8000/api/product/new',product)
      .then(res => {setProduct([...products,res.data])})
      .catch(err => console.log(err))
  }
  return (
    <div>
        <ProductForm onSubmitProp={createProduct} iTitle="" iPrice={0} iDescreption=""/>
        <hr/>
        <ProductList myProducts={products} setMyProduct={setProduct}/>
    </div>
  )
}

export default Main
