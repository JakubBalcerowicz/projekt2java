package Projekt2.Projekt2;

import java.util.List;

public interface OrderItemRepository extends GenericRepository<OrderItem> {
	List<OrderItem> getByOrderId(int orderId);

	OrderItem getByItemId(int itemId);
}
