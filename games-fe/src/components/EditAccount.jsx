import React, { useState } from 'react';
import UsuarioService from '../services/UserService';
import { useNavigate } from 'react-router-dom';

const EditarCuenta = () => {
    const navigate = useNavigate();
    const [idUsuario, setUsuarioId] = useState('');
    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [usuarios, setUsuarios] = useState([]);

    const handleCrearUsuario = () => {
        const usuario = { idUsuario, nombre, email, password };
        UsuarioService.createUser(usuario).then((response) => {
            alert('Se ha creado el usuario');
        }).catch((e) => { console.error("Algo ha ido mal", e) });
    };
    const handleActualizarUsuario = () => {
        const usuario = { id: idUsuario, nombre, email, password };
        UsuarioService.updateUser(idUsuario, usuario).then((response) => {
            alert('Se ha actualizado el usuario');
        }).catch((e) => { console.error("Algo ha ido mal", e) });
    };

    const handleEliminarUsuario = () => {
        UsuarioService.deleteUser(idUsuario).then(() => {
            alert(`Eliminado usuario con ID ${idUsuario}`);
        }).catch((e) => { console.error("Algo ha ido mal", e) });
    };

    const handleObtenerTodosLosUsuarios = () => {
        UsuarioService.getAllUsers().then((response) => {
            setUsuarios(response.data);
        });
    };

    return (
        <div style={{ marginRight: '700px', marginTop: '-600px' }}>
            <header className="header">
                <nav>
                    <button onClick={() => navigate('/home')}>Home</button>
                    <button onClick={() => navigate('/catalogo')}>Catalogo</button>
                    <button onClick={() => navigate('/carrito')}>Carrito</button>
                    <button onClick={() => navigate('/editar-cuenta')}>Editar Cuenta</button>
                </nav>           
            </header>
            <h2>Editar Cuenta</h2>
            <div>
                <label>ID Usuario:</label>
                <input type="text" value={idUsuario} onChange={(e) => setUsuarioId(e.target.value)} />
            </div>
            <div>
                <label>Nombre:</label>
                <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} />
            </div>
            <div>
                <label>Email:</label>
                <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div>
                <label>Password:</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>
            <div>
                <button onClick={handleCrearUsuario}>Crear usuario</button>
                <button onClick={handleActualizarUsuario}>Actualizar usuario</button>
                <button onClick={handleEliminarUsuario}>Eliminar usuario</button>
                <button onClick={handleObtenerTodosLosUsuarios}>Obtener todos los usuarios</button>
            </div>
            <div>
                <span style={{ color: 'black' }}>
                    <h3>Lista de Usuarios</h3>
                    <table>
                        <thead>
                            <tr>

                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                            {usuarios.map((usuario) => (
                                <tr key={usuario.id}>
                                    <td>{usuario.id}</td>
                                    <td>{usuario.nombre}</td>
                                    <td>{usuario.email}</td>
                                    <td>{usuario.password}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </span>
            </div>
        </div>
    );
};

export default EditarCuenta;
