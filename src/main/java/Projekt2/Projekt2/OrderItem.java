package Projekt2.Projekt2;

public class OrderItem extends Identity {
	private int orderId;
	private int itemId;

	public OrderItem(int orderId, int itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
