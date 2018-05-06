package Projekt2.Projekt2;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;

public class InMemoryGenericRepository<T extends Identity> implements GenericRepository<T> {
	private List<T> entities;

	public InMemoryGenericRepository() {
		this.entities = new ArrayList<>();
	}

	@Override
	public T getById(int id) {
		return Iterables.tryFind(this.entities, x -> x.getId() == id).orNull();
	}

	@Override
	public List<T> getAll() {
		return new ArrayList<>(this.entities);
	}

	@Override
	public boolean add(T entity) {
		if (this.getById(entity.getId()) != null) {
			return false;
		}

		this.entities.add(entity);
		return true;
	}

	@Override
	public boolean update(T entity) {
		T oldEntity = Iterables.tryFind(this.entities, x -> x.getId() == entity.getId()).orNull();
		if (oldEntity == null) {
			return false;
		}
		entities.remove(oldEntity);
		entities.add(entity);
		return true;
	}

	@Override
	public boolean delete(T entity) {
		if (this.getById(entity.getId()) == null) {
			return false;
		}
		entities.remove(entity);
		return true;
	}
}
