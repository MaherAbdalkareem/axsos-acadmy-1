import React, { useState } from 'react'
import {Link , useNavigate} from 'react-router-dom'
const AuthorForm = (props) => {
    const{iName , onSubmitProp ,errors}=props
    const [name,setName]=useState(iName)
    const navigate = useNavigate();
    const handelSubmit = e =>{
        e.preventDefault();
        onSubmitProp({name});
        
    }
  return (
    <div>
        <form onSubmit={handelSubmit} >
        {errors.map((err, index) => <p key={index}>{err}</p>)}
                
            <p>
                <label> Name : </label>
                <input type='text' onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <input type='submit' value='Send' />
        </form>
</div>
  )
}

export default AuthorForm