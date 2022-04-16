import React ,{useState} from 'react'

const Tab = (props) => {
    const myTab=["Tab1","Tab2","Tab3"]
    const [tab,setTab]=useState("")
    const handelTab=(e) =>{
        e.preventDefault();
        setTab(e.target.value)
        props.myFun(tab);
        console.log(e.target.value)
    }
  return (
    <div>
        {myTab.map((item,i) => 
        <button onClick={handelTab} key={i} value={item}>{item}</button>)}
    </div>
  )
}

export default Tab