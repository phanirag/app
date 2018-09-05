package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Transactional
@Repository
public class ItemDaoImpl implements IItemDao{

	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveItem(Item Item) {
		return (int) ht.save(Item);
	}

	@Override
	public void updateItem(Item Item) {
		ht.update(Item);
	}

	@Override
	public void deleteItem(int Itemid) {
		ht.delete(new Item(Itemid));
	}

	@Override
	public Item getItembyid(int Itemid) {
		return ht.get(Item.class, Itemid);
	}

	@Override
	public List<Item> getallItem() {
		return ht.loadAll(Item.class);
	}


}
