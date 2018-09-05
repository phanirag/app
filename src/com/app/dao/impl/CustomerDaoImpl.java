package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Transactional
@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveCustomer(Customer cust) {
		return (int) ht.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);
	}

	@Override
	public void deleteCustomer(int custid) {
		ht.delete(new Customer(custid));
	}

	@Override
	public Customer getCustomerbyid(int custid) {
		return ht.get(Customer.class, custid);
	}

	@Override
	public List<Customer> getallCustomer() {
		return ht.loadAll(Customer.class);
	}

	@Override
	public List<Object[]> getCustomerTypeCount() {
		String Hql="Select custType,count(custType) from com.app.model.Customer group by custType";
		@SuppressWarnings("unchecked")
		List<Object[]> list=ht.find(Hql);
		return list;
	}
	@Override
	public Customer getCustomerByEmail(String Email) {
		Customer cust=null;
		String Hql="from com.app.model.Customer where custEmail=?";
		@SuppressWarnings("unchecked")
		List<Customer> list=ht.find(Hql,Email);
		if(list!=null && list.size()>0){
			cust=list.get(0);
		}
		return cust;
	}

}
