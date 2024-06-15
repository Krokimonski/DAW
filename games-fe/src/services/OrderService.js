import axios from 'axios';

const API_URL = 'http://localhost:8080/pedidos';

class PedidoService {
  createOrder(pedido) {
    return axios.post(API_URL, pedido);
  }

  deleteOrder(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new PedidoService();