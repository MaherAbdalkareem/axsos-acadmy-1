import React,{useState,useEffect} from 'react'

const ProductForm = (props) => {
    const {iTitle , iPrice ,iDescreption , onSubmitProp} =props;
    const [title,setTitle]=useState(iTitle);
    const[price,setPrice]=useState(iPrice);
    const[description,setDescription]=useState(iDescreption);
    const handelSubmit = e =>{
        e.preventDefault();
        onSubmitProp({title,price,description})
    }
  return (
    <div>
        <form onSubmit={handelSubmit} >
            <p>
                <label> Title : </label>
                <input type='text' onChange={(e)=>setTitle(e.target.value)} value={title}/>
            </p>
            <p>
                <label> Price : </label>
                <input type='text' onChange={(e)=>setPrice(e.target.value)} value={price}/>
            </p>
            <p>
                <label> Description : </label>
                <input type='text' onChange={(e)=>setDescription(e.target.value)} value={description}/>
            </p>
            <input type='submit' />
        </form>
    </div>
  )
}

export default ProductForm