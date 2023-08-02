package com.entity;

public class Item {
	
	private int itemid;
	private String iname;
	private float cost;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemid, String iname, float cost) {
		super();
		this.itemid = itemid;
		this.iname = iname;
		this.cost = cost;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", iname=" + iname + ", cost=" + cost + "]";
	}
	
	

}
