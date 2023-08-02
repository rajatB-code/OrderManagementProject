package com.dao;

import com.entity.Order;

public interface OrderDao {
	public void addOrder(Order o);
	public void deleteOrder(int id);
	public void updateOrder(int id);
	public Order getOrderById(int id);
	public void displayAllOrder();

}
