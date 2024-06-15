import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import JuegoList from './components/Catalog';
import JuegoDetail from './components/GameDetail';
import Login from './components/Login';
import Registro from './components/Register';
import Home from './components/Home';
import Carrito from './components/Trolley';
import EditarCuenta from './components/EditAccount';
import EditarCatalogo from './components/EditCatalog';
import './App.css';

function App() {
  const [user, setUser] = useState(null);
  const [cart, setCart] = useState([]);

  const handleLogin = (loggedInUser) => {
    setUser(loggedInUser);
  };

  const addToCart = (juego) => {
    setCart([...cart, juego]);
    console.log('Juego añadido al carrito:', juego);
  };

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={user ? <Navigate to="/home" /> : <Login onLogin={handleLogin} />} />
          <Route path="/juegos/:id" element={<JuegoDetail />} />
          <Route path="/login" element={<Login onLogin={handleLogin} />} />
          <Route path="/register" element={<Registro />} />
          <Route path="/home" element={user ? <Home /> : <Navigate to="/login" />} />
          <Route path="/catalogo" element={user ? <JuegoList addToCart={addToCart} userId={user.id} /> : <Navigate to="/login" />} />
          <Route path="/carrito" element={user ? <Carrito cart={cart} setCart={setCart} /> : <Navigate to="/login" />} />
          <Route path="/editar-cuenta" element={user ? <EditarCuenta /> : <Navigate to="/login" />} />
          <Route path="/editar-catalogo" element={user ? <EditarCatalogo /> : <Navigate to="/login" />} />
        </Routes>
        {user ? (
          <nav>
            <a href="/catalogo">Cerrar sesión</a>
          </nav>
        ) : (
          <nav>
            <a href="/login">Login</a>
            <a href="/register">Register</a>
          </nav>
        )}
      </div>
    </Router>
  );
}

export default App;
