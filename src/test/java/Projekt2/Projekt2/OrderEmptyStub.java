package Projekt2.Projekt2;

import java.util.ArrayList;
import java.util.List;

public class OrderEmptyStub extends InMemoryGenericRepository<Order> implements OrderRepository {
	@Override
	public List<Order> getByClientId(int clientId) {
		return new ArrayList<>();
	}
}
