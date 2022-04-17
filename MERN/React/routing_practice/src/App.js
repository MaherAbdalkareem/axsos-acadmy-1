import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Link, 
  Route, 
  Switch
} from "react-router-dom";
import Home from './component/Home';
import Number from './component/Number';
import Color from './component/Color';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route path="/home">
          <Home />
        </Route>
        <Route exact path="/:number">
          <Number />
        </Route>
        <Route exact path="/:word/:color/:backColor">
          <Color />
        </Route>
      </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
