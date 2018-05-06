package Projekt2.Projekt2;

import java.util.ArrayList;
import java.util.List;

public class ItemCrud {

	private ItemRepository itemRepository;
	private OrderItemRepository orderItemRepository;

	public ItemCrud(ItemRepository itemRepository, OrderItemRepository orderItemRepository) {
		this.itemRepository = itemRepository;
		this.orderItemRepository = orderItemRepository;
	}

	public List<Item> getAllItems() {
		return itemRepository.getAll();
	}

	public List<Item> getAllFreeItems() {
		List<Item> free = new ArrayList<>();
		for (Item item : getAllItems()) {
			if (orderItemRepository.getByItemId(item.getId()) == null) {
				free.add(item);
			}
		}
		return free;
	}

	public boolean addItem(Item item) {
		if (item != null) {
			return itemRepository.add(item);
		}
		return false;
	}

	public boolean deleteItem(Item item) {
		List<Item> free = getAllFreeItems();
		if (!free.contains(item)) {
			return false;
		}
		return itemRepository.delete(item);
	}

	public boolean updateItem(Item item) {
		if (itemRepository.getById(item.getId()) == null) {
			return false;
		}

		return itemRepository.update(item);
	}

}
