import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListAnimalComponents from './components/ListAnimalComponents';
import HeaderComponents from './components/HeaderComponents';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponents />
          <div className="container">
          <Switch>
            <Route path = "/" exact component = {ListAnimalComponents}></Route>
            <Route path = "/animals" component = {ListAnimalComponents}></Route>
            {/*<Route path = "/add-employee/:id" component = {CreateEmployeeComponent}></Route>*/}
            {/*<Route path = "/view-employee/:id" component = {ViewEmployeeComponent}></Route>*/}
            {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
            </Switch>
          </div>
      </Router>
    </div>

  );
}

export default App;
