package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Override
	public int saveItem(Item Item) {
		return dao.saveItem(Item);
	}

	@Override
	public void updateItem(Item Item) {
		dao.updateItem(Item);
	}

	@Override
	public void deleteItem(int Itemid) {
		dao.deleteItem(Itemid);
	}

	@Override
	public Item getItembyid(int Itemid) {
		return dao.getItembyid(Itemid);
	}

	@Override
	public List<Item> getallItem() {
		return dao.getallItem();
	}

}
