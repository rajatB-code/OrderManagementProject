package com.dao;

import com.entity.Item;

public interface ItemDao {
	
	public void addItem();
	public void deleteItem(int id);
	public void updateItem(int id);
	public Item getItemById(int id);
	public void displayAllItem();
		

}
