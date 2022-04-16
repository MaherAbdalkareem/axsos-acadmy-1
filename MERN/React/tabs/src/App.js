import logo from './logo.svg';
import './App.css';
import Tab from './component/Tab';
import Context from './component/Context';
import {useState} from 'react'

function App() {
  const [input,setInput]=useState("")
  const myTab=(newInput) =>{
    setInput(newInput)
  }
  return (
    <div className="App">
      <Tab myFun={myTab} />
      <Context newTab={input} />
    </div>
  );
}

export default App;
