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
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path='/player/list' element={<Main></Main>}/>
          <Route exact path='/player/addplayer' element={<Add/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
