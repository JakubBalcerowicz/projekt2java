package Projekt2.Projekt2;

public class ClientCrud {

	ClientRepository clientRepository;
	OrderRepository orderRepository;

	public ClientCrud(ClientRepository clientRepository, OrderRepository orderRepository) {

		this.clientRepository = clientRepository;
		this.orderRepository = orderRepository;
	}

	public boolean addClient(Client client) {
		if (client == null) {
			throw new IllegalArgumentException("null");
		} else {
			return clientRepository.add(client);
		}
	}

	public boolean deleteClient(Client client) {

		if (!orderRepository.getByClientId(client.getId()).isEmpty()) {
			return false;
		}
		return clientRepository.delete(client);
	}

	public boolean updateClient(Client client) {
		if (client == null) {
			throw new IllegalArgumentException("null");
		}
		return clientRepository.update(client);
	}

}
