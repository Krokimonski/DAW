import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import JuegoService from '../services/GameService';

const EditarCatalogo = () => {
    const [idJuego, setIdJuego] = useState('');
    const [titulo, setTitulo] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [precio, setPrecio] = useState('');
    const [juegos, setJuegos] = useState([]);
    const [juego, setJuego] = useState(null);
    const navigate = useNavigate();

    const handleCrearJuego = () => {
        const nuevoJuego = { titulo, descripcion, precio };
        JuegoService.createGame(nuevoJuego).then((response) => {
            alert('Juego creado');
            handleObtenerTodosLosJuegos(); // Actualizar la lista de juegos después de crear
        }).catch((error) => {
            console.error('Error al crear el juego:', error);
        });
    };

    const handleObtenerJuegoPorId = () => {
        JuegoService.getGame(idJuego).then((response) => {
            setJuego(response.data);
        }).catch((error) => {
            console.error('Error al obtener el juego:', error);
        });
    };

    const handleActualizarJuego = () => {
        const juegoActualizado = { idJuego, titulo, descripcion, precio };
        JuegoService.updateGame(idJuego, juegoActualizado).then((response) => {
            alert('Juego actualizado');
        }).catch((error) => {
            console.error('Error al actualizar el juego:', error);
        });
    };

    const handleEliminarJuego = () => {
        JuegoService.deleteGame(idJuego).then(() => {
            alert(`Juego ${idJuego} eliminado`);
            handleObtenerTodosLosJuegos(); // Actualizar la lista de juegos después de eliminar
        }).catch((error) => {
            console.error('Error al eliminar el juego:', error);
        });
    };

    const handleObtenerTodosLosJuegos = () => {
        JuegoService.getAllGames().then((response) => {
            setJuegos(response.data);
        }).catch((error) => {
            console.error('Error al obtener los juegos:', error);
        });
    };

    return (
        <div style={{ marginRight: '400px', marginTop: '-300px' }}>
            <header className="header">
                <nav>
                    <button onClick={() => navigate('/home')}>Home</button>
                    <button onClick={() => navigate('/catalogo')}>Catalogo</button>
                    <button onClick={() => navigate('/carrito')}>Carrito</button>
                    <button onClick={() => navigate('/editar-catalogo')}>Editar Catalogo</button>
                </nav>
            </header>
            <div>
                <h2>Editar Catálogo</h2>
                <div>
                    <label>ID Juego:</label>
                    <input type="text" value={idJuego} onChange={(e) => setIdJuego(e.target.value)} />
                </div>
                <div>
                    <label>Título:</label>
                    <input type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)} />
                </div>
                <div>
                    <label>Descripción:</label>
                    <input type="text" value={descripcion} onChange={(e) => setDescripcion(e.target.value)} />
                </div>
                <div>
                    <label>Precio:</label>
                    <input type="text" value={precio} onChange={(e) => setPrecio(e.target.value)} />
                </div>
                <div>
                    <button onClick={handleCrearJuego}>Crear juego</button>
                    <button onClick={handleObtenerJuegoPorId}>Obtener juego por ID</button>
                    <button onClick={handleActualizarJuego}>Actualizar juego</button>
                    <button onClick={handleEliminarJuego}>Eliminar Juego</button>
                    <button onClick={handleObtenerTodosLosJuegos}>Obtener todos los juegos</button>
                </div>
                {juego && (
                    <div>
                        <span style={{ color: 'black' }}>
                            <h3>Detalles del juego</h3>
                            <p>ID: {juego.idJuego}</p>
                            <p>Título: {juego.titulo}</p>
                            <p>Descripción: {juego.descripcion}</p>
                            <p>Precio: {juego.precio} €</p>
                        </span>
                    </div>
                )}
                <div>
                    <span style={{ color: 'black' }}>
                        <h3>Lista de juegos</h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Título</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                {juegos.map((juego) => (
                                    <tr key={juego.idJuego}>
                                        <td>{juego.idJuego}</td>
                                        <td>{juego.titulo}</td>
                                        <td>{juego.descripcion}</td>
                                        <td>{juego.precio} €</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default EditarCatalogo;
