import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import JuegoList from './components/JuegoList';
import JuegoDetail from './components/JuegoDetail';

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/" exact component={JuegoList} />
          <Route path="/juegos/:id" component={JuegoDetail} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;