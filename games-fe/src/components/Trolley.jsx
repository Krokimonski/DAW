import React from 'react';
import { useNavigate } from 'react-router-dom';
import PedidoService from '../services/OrderService';

const Carrito = ({ cart, setCart }) => {
    const navigate = useNavigate();
    const total = cart.reduce((acc, juego) => acc + juego.precio, 0);

    const handleRemoveFromCart = (index, idJuego) => {
        // Eliminar pedido del backend (si es necesario)
        PedidoService.deleteOrder(idJuego).then(() => {
            // Eliminar pedido del carrito en el frontend
            const newCart = cart.filter((_, i) => i !== index);
            setCart(newCart);
        });
    };

    return (
        <div style={{ marginRight: '700px', marginTop: '-600px' }}>
            <header className="header">
                <nav>
                    <button onClick={() => navigate('/home')}>Home</button>
                    <button onClick={() => navigate('/catalogo')}>Catalogo</button>
                    <button onClick={() => navigate('/carrito')}>Carrito</button>
                </nav>
            </header>
            <h2>Carrito de Compras</h2>
            <ul>
                {cart.map((juego, index) => (
                    <li key={index}>
                        <span style={{ color: 'black' }}>
                            {juego.titulo} - {juego.descripcion} - {juego.precio} €
                        </span>
                        <button style={{ marginRight: '100px' }} onClick={() => handleRemoveFromCart(index, juego.idJuego)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <span style={{ color: 'black' }}>
                <h3>Total: {total} €</h3>
            </span>
            <button onClick={() => navigate()}>Finalizar compra</button>
        </div>
    );
};

export default Carrito;
