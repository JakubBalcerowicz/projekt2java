package Projekt2.Projekt2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemCrudEasyMockTest {
	private ItemRepository itemRepository;
	private OrderItemRepository orderItemRepository;
	private ItemCrud Crud;
	private Item item1;
	private Item item2;

	@BeforeEach
	void setup() {
		this.itemRepository = EasyMock.createMock(ItemRepository.class);
		this.orderItemRepository = EasyMock.createMock(OrderItemRepository.class);
		this.Crud = new ItemCrud(itemRepository, orderItemRepository);
		this.item1 = new Item(1, "iPod", 600.0);
		this.item2 = new Item(1, "iPad", 1000.0);
	}

	@Test
	void getAllItemsEmptyList() {
		// Arrange
		expect(itemRepository.getAll()).andReturn(new ArrayList<>());
		replay(itemRepository);

		// Act
		List<Item> items = Crud.getAllItems();

		// Assert
		assertThat(items).isEmpty();
	}

	@Test
	void addItem() {
		// Arrange
		expect(itemRepository.add(item1)).andReturn(true);
		replay(itemRepository);

		// Act
		boolean result = Crud.addItem(item1);

		// Assert
		assertThat(result).isTrue();
	}

	@Test
	void addItemNull() {
		// Arrange
		expect(itemRepository.add(null)).andReturn(true);
		replay(itemRepository);

		// Act
		boolean result = Crud.addItem(null);

		// Assert
		assertThat(result).isFalse();
	}

	@Test
	void getAllItems() {
		// Arrange
		List<Item> items = Arrays.asList(item1, item2);
		expect(itemRepository.getAll()).andReturn(items);
		replay(itemRepository);

		// Act
		List<Item> result = Crud.getAllItems();

		// Assert
		assertThat(result).containsExactlyInAnyOrder(item1, item2);
	}

	@Test
	void getAllFreeItemsEmptyList() {
		// Arrange
		expect(itemRepository.getAll()).andReturn(new ArrayList<>());
		replay(itemRepository);

		// Act
		List<Item> items = Crud.getAllFreeItems();

		// Assert
		assertThat(items).isEmpty();
	}

	@Test
	void getAllFreeItemsOnListOnlyOrderedItems() {
		// Arrange
		List<Item> items = Arrays.asList(item1);
		expect(itemRepository.getAll()).andReturn(items);
		replay(itemRepository);
		expect(orderItemRepository.getByItemId(item1.getId())).andReturn(new OrderItem(1, item1.getId()));
		replay(orderItemRepository);
		// Act
		List<Item> test = Crud.getAllFreeItems();

		// Assert
		assertThat(test).isEmpty();
	}

	@Test
	void getAllFreeItemsOnListFreeAndOrderedItem() {
		// Arrange
		List<Item> items = Arrays.asList(item1, item2);
		expect(itemRepository.getAll()).andReturn(items);
		replay(itemRepository);
		expect(orderItemRepository.getByItemId(item1.getId())).andReturn(new OrderItem(1, item1.getId()));
		expect(orderItemRepository.getByItemId(item2.getId())).andReturn(null);
		replay(orderItemRepository);
		// Act
		List<Item> test = Crud.getAllFreeItems();

		// Assert
		assertThat(test).hasSize(1);
	}

	@Test
	void deleteItem() {
		// Arrange
		List<Item> items = Arrays.asList(item1, item2);
		expect(itemRepository.getAll()).andReturn(items);
		expect(itemRepository.delete(item1)).andReturn(true);
		replay(itemRepository);
		expect(orderItemRepository.getByItemId(item1.getId())).andReturn(null);
		expect(orderItemRepository.getByItemId(item2.getId())).andReturn(null);
		replay(orderItemRepository);

		// Act
		boolean test = Crud.deleteItem(item1);

		// Assert
		assertThat(test).isTrue();
	}

	@Test
	void deleteItemIsNotFree() {
		// Arrange
		List<Item> items = Arrays.asList(item1);
		expect(itemRepository.getAll()).andReturn(items);
		expect(itemRepository.delete(item1)).andReturn(false);
		replay(itemRepository);
		expect(orderItemRepository.getByItemId(item1.getId())).andReturn(new OrderItem(1, item1.getId()));
		replay(orderItemRepository);

		// Act
		boolean test = Crud.deleteItem(item1);

		// Assert
		assertThat(test).isFalse();
	}

	@Test
	void updateNotExistingItem() {
		// Arrange
		expect(itemRepository.getById(anyInt())).andReturn(null);
		replay(itemRepository);

		// Act
		boolean test = Crud.updateItem(item2);

		// Assert
		assertThat(test).isFalse();

	}

	@Test
	void updateItem() {
		// Arrange
		List<Item> items = Arrays.asList(item1);
		expect(itemRepository.getAll()).andReturn(items);
		expect(itemRepository.getById(item1.getId())).andReturn(item1);
		expect(itemRepository.update(item1)).andReturn(true);
		replay(itemRepository);

		// Act
		boolean test = Crud.updateItem(item1);

		// Assert
		assertThat(test).isTrue();

	}

}
