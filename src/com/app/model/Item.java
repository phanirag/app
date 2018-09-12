package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Itemtab")
public class Item {

	@Id
	@Column(name="ItemId")
	private int itemId;
	@Column(name="Name")
	private String itemName;
	@Column(name="Cost")
	private Double itemCost;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="cId")
	private Customer custId;
	
	public Item() {
		super();
	}

	public Item(int itemId) {
		this.itemId = itemId;
	}

	public Item(int itemId, String itemName, Double itemCost,
			Customer custId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.custId = custId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public Customer getCustId() {
		return custId;
	}

	public void setCustId(Customer custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCost=" + itemCost + ", custId=" + custId + "]";
	}
	
}
