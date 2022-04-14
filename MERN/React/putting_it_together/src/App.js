import logo from './logo.svg';
import './App.css';
import PersonCard from './component/PersonCard'
function App() {
  return (
    <div className="App">
      <PersonCard firstname={"Doe"} lastname={"Jane"} age={45} color={"Black"}/>
      <PersonCard firstname={"Smith"} lastname={"John"} age={88} color={"Brown"}/>
    </div>
  );
}

export default App;
