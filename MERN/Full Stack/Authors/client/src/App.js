import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Link, 
  Route, 
  Routes, 
  Switch
} from "react-router-dom";
import Main from './view/Main';
import Add from './view/Add';
import Update from './view/Update';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path='/' element={<Main />}/>
          <Route exact path='/new' element={<Add />}/>
          <Route exact path= '/edit/:id' element={<Update/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
