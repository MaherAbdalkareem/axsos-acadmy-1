import logo from './logo.svg';
import React from 'react';
import './App.css';
import Main from './view/Main';
import {
  BrowserRouter,
  Link, 
  Route, 
  Routes, 
  Switch
} from "react-router-dom";
import Update from './view/Update';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path='/product' element={<Main/>}/>
          <Route exact path='/product/:id' element={<Update/>}/>
        </Routes>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
