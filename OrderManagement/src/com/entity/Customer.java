package com.entity;

public class Customer {
	
	private int cid;
	private String fname;
	private String lname;
	private long mno;
	private String email;
	private String address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int cid, String fname, String lname, long mno, String email, String address) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.mno = mno;
		this.email = email;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getMno() {
		return mno;
	}

	public void setMno(long mno) {
		this.mno = mno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", mno=" + mno + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
	

}
