import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HomeComponent from './components/HomeComponent';
import ListAnimalComponent from './components/ListAnimalComponent';
import InfoComponent from './components/InfoComponent';
import CreateAnimalComponent from './components/CreateAnimalComponent';
import ViewAnimalComponent from './components/ViewAnimalComponent';
import HeaderComponent from './components/HeaderComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
          <div className="container">
          <Switch>
            <Route path = "/" exact component = {HomeComponent}></Route>
            <Route path = "/animals" component = {ListAnimalComponent}></Route>
            <Route path = "/infos" component = {InfoComponent}></Route>
            <Route path = "/add-animal/:id" component = {CreateAnimalComponent}></Route>
            <Route path = "/view-animal/:id" component = {ViewAnimalComponent}></Route>
            </Switch>
          </div>
      </Router>
    </div>

  );
}

export default App;
