package com.dto;

public class OrderDetailsDto {
	private int id;
	OrdersDto order_id;
	ProductDto product_id;
	private int quantity;

	public OrderDetailsDto() {
		super();
	}

	public OrderDetailsDto(int id, OrdersDto order_id, ProductDto product_id, int quantity) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrdersDto getOrder_id() {
		return order_id;
	}

	public void setOrder_id(OrdersDto order_id) {
		this.order_id = order_id;
	}

	public ProductDto getProduct_id() {
		return product_id;
	}

	public void setProduct_id(ProductDto product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order_id=" + order_id + ", product_id=" + product_id + ", quantity="
				+ quantity + "]";
	}

}
