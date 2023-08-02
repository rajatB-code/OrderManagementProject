package com.entity;

public class Order {

	private int order_id;
	private int cid;
	private int item_id;
	private int qty;
	private float totalcost;
	private String ostatus;
	private String pay_status;
	

	public Order() {
		super();

	}

	public Order(int order_id, int cid, int item_id, int qty, float totalcost, 
			String ostatus, String pay_status) {
		super();
		this.order_id = order_id;
		this.cid = cid;
		this.item_id = item_id;
		this.qty = qty;
		this.totalcost = totalcost;
		this.ostatus = ostatus;
		this.pay_status = pay_status;
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}
	
	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cid=" + cid + ", item_id=" + item_id + ", qty=" + qty + ", totalcost="
				+ totalcost + ", ostatus=" + ostatus + ", pay_status=" + pay_status + "]";
	}


}
