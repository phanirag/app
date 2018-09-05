package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {
	

	public int saveCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(int custid);
	public Customer getCustomerbyid(int custid);
	public List<Customer> getallCustomer();
	public List<Object[]> getCustomerTypeCount();
	public Customer getCustomerByEmail(String Email);
}
