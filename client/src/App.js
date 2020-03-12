import React from 'react';
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Home from './components/Home'
import Register from './components/Register'
import Login from './components/Login'
import UsersList from './components/UsersList'
import Navbar from './components/Navbar'


function App() {
  window.sessionStorage.setItem('Auth',false);
  return (
    <BrowserRouter>
    <div className="App">
      <Navbar/>
      <Switch>
        <Route exact path="/" component={Home}/>
        <Route path="/register" component={Register}/>
        <Route path="/login" component={Login}/>
        <Route path="/usersList" component={UsersList}/>
      </Switch>
      
    </div>
    </BrowserRouter>
  );
}

export default App;
