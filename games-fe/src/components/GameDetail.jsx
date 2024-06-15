import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import JuegoService from '../services/GameService';

const JuegoDetail = () => {
  const { id } = useParams();
  const [juego, setJuego] = useState(null);

  useEffect(() => {
    JuegoService.getGame(id).then((response) => {
      setJuego(response.data);
    });
  }, [id]);

  return (
    <div>
      {juego ? (
        <div>
          <h2>{juego.titulo}</h2>
          <p>{juego.descripcion}</p>
          <p>Precio: {juego.precio} €</p>
        </div>
      ) : (
        <p>Cargando...</p>
      )}
    </div>
  );
};

export default JuegoDetail;
