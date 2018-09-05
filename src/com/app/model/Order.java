package com.app.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Order_tab")
public class Order {

	@Id
	@Column(name="oId")
	private int orderId;
	@Column(name="oCode")
	private String orderCode;
	@Column(name="oCost")
	private double orderCost;
	@Column(name="itemNames")
	private String iName;
	@Column(name="custId")
	@JsonIgnore
	private int custId;
	
	public Order() {
		super();
	}

	public Order(int orderId) {
		this.orderId = orderId;
	}

	public Order(int orderId, String orderCode, double orderCost, String iName,
			int custId) {
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.orderCost = orderCost;
		this.iName = iName;
		this.custId = custId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCode=" + orderCode
				+ ", orderCost=" + orderCost + ", iName=" + iName + ", custId="
				+ custId + "]";
	}
	
}
