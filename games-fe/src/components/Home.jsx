import React from 'react';
import { useNavigate, Link } from 'react-router-dom';
import imagen from '../assets/img/MG.jpg';
import logo from '../assets/img/logo_MG.jpg';
import '../App.css';

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <header className="header">
        <nav>
          <button onClick={() => navigate('/home')}>Home</button>
          <button onClick={() => navigate('/catalogo')}>Catalogo</button>
          <button onClick={() => navigate('/carrito')}>Carrito</button>
          <button onClick={() => navigate('/editar-cuenta')}>Editar Cuenta</button>
        </nav>
        <div className="logo-container">
          <img src={logo} alt="Logo" style={{ height: '50px' }} />
        </div>
      </header>
      <div className="image-container">
        <img src={imagen} alt="Imagen" />
      </div>
    </div>
  );
};

export default Home;
