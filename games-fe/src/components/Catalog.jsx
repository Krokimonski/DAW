import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import JuegoService from '../services/GameService';
import PedidoService from '../services/OrderService';

const JuegoList = ({ addToCart }) => {
  const [juegos, setJuegos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    JuegoService.getAllGames().then((response) => {
      setJuegos(response.data);
    });
  }, []);

  const handleAddToCart = (juego) => {
    const pedido = {
      fecha: new Date(),
      idUsuario: 1,
      estadoPago: 'Pendiente',
      total: juego.precio,
      juegos: [juego]
    };

    PedidoService.createOrder(pedido).then(() => {
      addToCart(juego);
    });
  };

  return (
    <div style={{ marginRight: '400px', marginTop: '-600px' }}>
      <header className="header">
        <nav>
        <button onClick={() => navigate('/home')}>Home</button>
        <button onClick={() => navigate('/catalogo')}>Catalogo</button>
        <button onClick={() => navigate('/carrito')}>Carrito</button>
        <button onClick={() => navigate('/editar-catalogo')}>Editar Catalogo</button>
        </nav>
      </header>
      <h2>Catálogo</h2>
      <ul>
        {juegos.map((juego) => (
          <li key={juego.idJuego}>
            <button style={{ marginRight: '100px' }} onClick={() => handleAddToCart(juego)}>Añadir al carrito</button>
            <span style={{ color: 'black' }}>
              {juego.titulo} - {juego.descripcion} - {juego.precio} €
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default JuegoList;

