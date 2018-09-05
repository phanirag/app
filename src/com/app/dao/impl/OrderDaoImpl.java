package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderDao;
import com.app.model.Order;

@Repository
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveOrder(Order order) {
		return (int) ht.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		ht.update(order);
	}

	@Override
	public void deleteOrder(int id) {
		ht.delete(new Order(id));
	}

	@Override
	public Order getOrderById(int id) {
		return ht.get(Order.class, id);
	}

	@Override
	public List<Order> getAllOrder() {
		return ht.loadAll(Order.class);
	}


}
