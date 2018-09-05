package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {

	public int saveItem(Item Item);
	public void updateItem(Item Item);
	public void deleteItem(int Itemid);
	public Item getItembyid(int Itemid);
	public List<Item> getallItem();
}
