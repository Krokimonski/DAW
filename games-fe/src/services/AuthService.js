import axios from 'axios';

const API_URL = 'http://localhost:8080/auth';

class AuthService {
  login(email, password) {
    return axios.post(`${API_URL}/login`, { email, password });
  }

  register(nombre, email, password) {
    return axios.post(`${API_URL}/register`, { nombre, email, password });
  }
}

export default new AuthService();