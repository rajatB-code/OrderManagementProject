package com.dao;

import com.entity.Customer;

public interface CustomerDao {
	
	public void addCustomer(Customer c);
	public void deleteCustomer(int cid);
	public void updateCustomer(int cid);
	public Customer getCustomerById(int cid);
	public void displayAllCustomer();
	
	

}
