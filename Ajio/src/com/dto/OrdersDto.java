package com.dto;

import java.sql.Timestamp;

public class OrdersDto {
	private int id;
	UserDto user_id;
	private int total_amount;
	private Timestamp order_date;

	public OrdersDto() {
		super();
	}

	public OrdersDto(int id, UserDto user_id, int total_amount, Timestamp order_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.order_date = order_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUser_id() {
		return user_id;
	}

	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "OrdersDto [id=" + id + ", user_id=" + user_id + ", total_amount=" + total_amount + ", order_date="
				+ order_date + "]";
	}

}
