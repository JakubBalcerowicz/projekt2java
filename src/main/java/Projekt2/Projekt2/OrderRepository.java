package Projekt2.Projekt2;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order> {
	List<Order> getByClientId(int clientId);
}
