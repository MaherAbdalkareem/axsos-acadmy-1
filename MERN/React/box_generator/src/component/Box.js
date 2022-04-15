import React,{useState} from 'react'

const Box = (props) => {
    const [color, setcolor] = useState("")
    
    const handelcolor=(e) =>{
        setcolor(e.target.value)
        
    }
    const genenrat=(e) =>{
        e.preventDefault();
        props.myFun(color)
        setcolor("")
    }
    
  return (
    <div>
        <form onSubmit={genenrat}>
            <div>
                <label>color</label>
                <input type="text" onChange={handelcolor}/>
                <button>Add</button>
            </div>
        </form>
    </div>
  )
}

export default Box