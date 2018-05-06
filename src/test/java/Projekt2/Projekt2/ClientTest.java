package Projekt2.Projekt2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

	private ClientRepository clientRepository;
	private OrderRepository orderRepository;
	private ClientCrud Stub;
	private ClientCrud Crud;
	private Client client;

	@BeforeEach
	void setup() {
		this.clientRepository = new ClientRepositoryInMemoryMock();
		this.orderRepository = new OrderEmptyStub();
		this.Stub = new ClientCrud(this.clientRepository, new OrderStub());
		this.Crud = new ClientCrud(clientRepository, orderRepository);
		this.client = new Client(1, "Jakub", "Balcerowicz", "jb@wp.com");
	}

	@Test
	void addClientNull() {
		assertThatThrownBy(() -> Crud.addClient(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("null");
	}

	@Test
	void addTwoClients() {
		// Act
		clientRepository.add(new Client(2, "Olek", "Kosma", "ok@wp.com"));
		clientRepository.add(new Client(3, "Dawid", "Cwik", "dc@wp.com"));

		// Assert
		assertThat(clientRepository.getAll()).hasSize(2);
	}

	@Test
	void addNewClient() {

		assertThat(Crud.addClient(client)).isTrue();
	}

	@Test
	void deleteNotExistingClient() {
		assertThat(Crud.deleteClient(client)).isFalse();
	}

	@Test
	void deleteExistingClientClientListSizeZero() {
		// Arrange
		clientRepository.add(client);

		// Act
		Crud.deleteClient(client);

		// Assert
		assertThat(clientRepository.getAll()).hasSize(0);

	}

	@Test
	void deleteClientWihtOrder() {
		// Arrange
		clientRepository.add(client);

		// Act
		boolean result = Stub.deleteClient(client);

		// Assert
		assertThat(result).isFalse();
	}

	@Test
	void updateClientSurName() {
		// Arrange
		clientRepository.add(client);

		// Act
		client.setSurName("ASD");
		Crud.updateClient(client);

		// Assert
		Client updateResult = clientRepository.getById(client.getId());
		assertThat(updateResult.getSurName()).isEqualTo("ASD");
	}

	@Test
	void updateClientisNull() {
		assertThatThrownBy(() -> Crud.updateClient(null)).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("null");
	}

}
