package Projekt2.Projekt2;

import java.util.Arrays;
import java.util.List;

public class OrderStub extends InMemoryGenericRepository<Order> implements OrderRepository {
	@Override
	public List<Order> getByClientId(int clientId) {
		return Arrays.asList(new Order(1, clientId));
	}
}