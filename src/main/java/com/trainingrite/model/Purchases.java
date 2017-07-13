package com.trainingrite.model;

public class Purchases {
	
	private String  _id;
	private double totalPrice;
	private int totalItems;
	
	public Purchases(String _id, double totalPrice, int totalItems) {
		super();
		this._id = _id;
		this.totalPrice = totalPrice;
		this.totalItems = totalItems;
	}
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	@Override
	public String toString() {
		return "CustomerPurchase [_id=" + _id + ", totalPrice=" + totalPrice + ", totalItems=" + totalItems + "]";
	}
}
