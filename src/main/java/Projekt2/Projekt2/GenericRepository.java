package Projekt2.Projekt2;

import java.util.List;

public interface GenericRepository<T extends Identity> {
	T getById(int id);

	List<T> getAll();

	boolean add(T entity);

	boolean update(T entity);

	boolean delete(T entity);
}
