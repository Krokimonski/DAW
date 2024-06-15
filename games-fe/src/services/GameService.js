import axios from 'axios';

const API_URL = 'http://localhost:8080/juegos';

class JuegoService {
  getAllGames() {
    return axios.get(API_URL);
  }

  getGame(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  createGame(juego) {
    return axios.post(API_URL, juego);
  }

  updateGame(id, juego) {
    return axios.put(`${API_URL}/${id}`, juego);
  }

  deleteGame(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new JuegoService();