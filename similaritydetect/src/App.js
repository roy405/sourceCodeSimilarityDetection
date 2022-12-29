import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import './App.css';
import Login from './Login';
import DocumentUpload from './DocumentUpload';
import ResultsProcess from './ResultsProcess';

class App extends Component{
  render(){
    return(
      <Router>
        <Routes>
          <Route path='/' element={<Login/>}/>
          <Route path='/documentUpload' element={<DocumentUpload/>}/>
          <Route path='/resultsProcess' element={<ResultsProcess/>}/>
        </Routes>
      </Router>
    )
  }
}


export default App;
