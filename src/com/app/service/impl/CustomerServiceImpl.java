package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;
	
	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public void deleteCustomer(int custid) {
		dao.deleteCustomer(custid);
	}

	@Override
	public Customer getCustomerbyid(int custid) {
		return dao.getCustomerbyid(custid);
	}

	@Override
	public List<Customer> getallCustomer() {
		return dao.getallCustomer();
	}

	@Override
	public List<Object[]> getCustomerTypeCount() {
		return dao.getCustomerTypeCount();
	}
	
	@Override
	public Customer getCustomerByEmail(String Email) {
		return dao.getCustomerByEmail(Email);
	}


}
