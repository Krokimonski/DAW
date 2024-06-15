import axios from 'axios';

const API_URL = 'http://localhost:8080/usuarios';

class UsuarioService {
  getAllUsers() {
    return axios.get(API_URL);
  }

  createUser(usuario) {
    return axios.post(API_URL, usuario);
  }

  updateUser(id, usuario) {
    return axios.put(`${API_URL}/${id}`, usuario);
  }

  deleteUser(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new UsuarioService();