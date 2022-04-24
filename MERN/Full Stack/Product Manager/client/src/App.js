import logo from './logo.svg';
import './App.css';
import Main from './view/Main';
import {
  BrowserRouter,
  Link, 
  Route, 
  Routes, 
  Switch
} from "react-router-dom";
import Details from './view/Details';
function App() {
  return (
    <div className="App">
      <BrowserRouter >
      <Routes>
          <Route exact path='/product/new' element = {< Main />} />
          <Route exact path='/product/:id' element = {<Details />}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
