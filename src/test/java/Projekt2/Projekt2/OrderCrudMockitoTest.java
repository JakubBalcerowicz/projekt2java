package Projekt2.Projekt2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderCrudMockitoTest {
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;
	private ItemRepository itemRepository;
	private OrderCrud Crud;
	private Order order1;
	private Item item1;
	private Client client1;

	@BeforeEach
	void setup() {
		this.orderRepository = Mockito.mock(OrderRepository.class);
		this.orderItemRepository = Mockito.mock(OrderItemRepository.class);
		this.itemRepository = Mockito.mock(ItemRepository.class);
		this.Crud = new OrderCrud(orderRepository, orderItemRepository);
		this.order1 = new Order(1, 1);
		this.item1 = new Item(1, "iPod", 600);
		this.client1 = new Client(1, "Jakub", "Balcerowicz", "JK@wp.pl");
	}

	@Test
	void addItemToOrderBothNulls() {
		// Assert
		assertThat(Crud.addItemToOrder(null, null)).isFalse();
	}

	@Test
	void addItemToOrder() {
		// Arrange
		doReturn(null).when(orderItemRepository).getByItemId(item1.getId());
		doReturn(true).when(orderItemRepository).add(any());

		// Act
		boolean test = Crud.addItemToOrder(item1, order1);

		// Assert
		assertThat(test).isTrue();
	}

	@Test
	void deleteItemFromOrder() {
		// Arrange
		OrderItem orderItem1 = new OrderItem(order1.getId(), item1.getId());
		List<OrderItem> orderItems = Arrays.asList(orderItem1);
		doReturn(orderItems).when(orderItemRepository).getByOrderId(order1.getId());
		doReturn(item1).when(itemRepository).getById(item1.getId());
		// Act
		boolean result = Crud.deleteItemFromOrder(item1, order1);

		// Assert
		assertThat(result).isTrue();
	}

	@Test
	void getClientOrdersNull() {
		assertThatThrownBy(() -> Crud.getOrders(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("null");
	}

	@Test
	void getClientOrder() {
		// Arrange

		List<Order> expectedOrders = Arrays.asList(new Order(1, client1.getId()), new Order(2, client1.getId()));
		doReturn(expectedOrders).when(orderRepository).getByClientId(client1.getId());

		// Act
		List<Order> result = Crud.getOrders(client1);

		// Assert
		assertThat(result).containsAll(expectedOrders);
	}

	@Test
	void addItemToTwoOrders() {
		// Arrange
		doReturn(null).when(orderItemRepository).getByItemId(item1.getId());
		doReturn(true).when(orderItemRepository).add(any());
		Order order2 = new Order(1, 2);

		// Act
		Crud.addItemToOrder(item1, order1);
		boolean test1 = Crud.addItemToOrder(item1, order2);

		// Assert
		assertThat(test1).isTrue();
	}

	@Test
	void delleteFromNullOrder() {
		assertThatThrownBy(() -> Crud.deleteItemFromOrder(null, order1)).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("null");
	}

	@Test
	void deleteItemNotinOrder() {
		// Arrange
		Item item2 = new Item(2, "iPad", 1000);
		OrderItem orderItem1 = new OrderItem(order1.getId(), item2.getId());
		List<OrderItem> orderItems = Arrays.asList(orderItem1);
		doReturn(orderItems).when(orderItemRepository).getByOrderId(order1.getId());
		doReturn(item2).when(itemRepository).getById(item2.getId());
		// Act
		boolean result = Crud.deleteItemFromOrder(item2, order1);

		// Assert
		assertThat(result).isFalse();
	}

}
