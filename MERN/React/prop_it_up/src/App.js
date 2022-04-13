
import './App.css';
import PersonCard from './component/PersonCard'
function App() {
  return (
    <div className="App">
      <PersonCard firstname={"Doe"} lastname={"Jane"} age={"45"} color={"Black"}/>
      <PersonCard firstname={"Smith"} lastname={"John"} age={"88"} color={"Brown"}/>
      <PersonCard firstname={"Fillmore"} lastname={"Millard"} age={"50"} color={"Brown"}/>
      <PersonCard firstname={"Smith"} lastname={"Maria"} age={"62"} color={"Brown"}/>
    </div>
  );
}

export default App;
