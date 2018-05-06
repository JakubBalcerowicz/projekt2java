package Projekt2.Projekt2;

import java.util.List;

public class OrderCrud {

	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;

	public OrderCrud(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
	}

	public boolean addItemToOrder(Item item, Order order) {
		if (item == null || order == null) {
			return false;
		}

		OrderItem orderItem = new OrderItem(order.getId(), item.getId());
		return orderItemRepository.add(orderItem);
	}

	public boolean deleteItemFromOrder(Item item, Order order) {
		if (item == null || order == null) {

			throw new IllegalArgumentException("null");
		}
		List<OrderItem> orderItems = orderItemRepository.getByOrderId(order.getId());
		for (OrderItem o : orderItems) {
			if (item.getId() == 1) {
				orderItemRepository.delete(o);
				return true;
			}
		}

		return false;
	}

	public List<Order> getOrders(Client client) {
		if (client == null) {
			throw new IllegalArgumentException("null");
		}

		return orderRepository.getByClientId(client.getId());
	}
}
