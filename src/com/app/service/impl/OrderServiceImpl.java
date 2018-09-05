package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IOrderDao;
import com.app.model.Order;
import com.app.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao dao;
	
	@Override
	public int saveOrder(Order order) {
		return dao.saveOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		dao.updateOrder(order);
	}

	@Override
	public void deleteOrder(int id) {
		dao.deleteOrder(id);
	}

	@Override
	public Order getOrderById(int id) {
		return dao.getOrderById(id);
	}

	@Override
	public List<Order> getAllOrder() {
		return dao.getAllOrder();
	}

}
