import logo from './logo.svg';
import './App.css';
import Box from './component/Box';
import {useState} from 'react';
import Display from './component/Display';
function App() {
  const [newColor,setNewColor]=useState([])
  const color=(theColor) =>{
    setNewColor([...newColor,theColor]);
    
  }
  return (
    <div className="App">
      <Box myFun={color}/>
      <Display box={newColor}/>
    </div>
  );
}

export default App;
