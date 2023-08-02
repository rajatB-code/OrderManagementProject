package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Connect.DBConnection;
import com.dao.OrderDao;
import com.entity.Order;

public class OrderDaoimpl implements OrderDao {
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	static Scanner sc= new Scanner(System.in);
	public  OrderDaoimpl()
	{
		con= DBConnection.getConnect();
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	@Override
	public void addOrder(Order o) {
		try {
			st = con.createStatement();
			float cost = 0;
			ResultSet rs = st.executeQuery("select * from  item");
			while (rs.next()) {
				int id = rs.getInt(1);
				if (o.getItem_id() == id) {
					cost = rs.getFloat(3);
//					System.out.println(cost);
				}
			}
			pst=con.prepareStatement("insert into orderdetails values(?,?,?,?,?,?,?)");
			pst.setInt(1, o.getOrder_id());
			pst.setInt(2, o.getCid());
			pst.setInt(3, o.getItem_id());
			pst.setInt(4, o.getQty());
			
			float cost1 = o.getQty() * cost;
	
			pst.setFloat(5, cost1);

    		pst.setString(6, o.getOstatus());
			pst.setString(7, o.getPay_status());

			int row=pst.executeUpdate();
			if(row> 0) {
				System.out.println("Order done..");
			}else {
				System.out.println("error...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteOrder(int Order_id) {
		try {
			pst=con.prepareStatement("delete from orderdetails where order_id=?");
			pst.setInt(1,Order_id);
			int row=pst.executeUpdate();
			if(row> 0) {
				System.out.println("deleted order....");
			}else {
				System.out.println("error...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateOrder(int Order_id) {
		try {
			Order o=new Order();
			o=getOrderById(Order_id);
			if(o!=null) {
				System.out.println("------------order details are----------");
				System.out.println(o);
				System.out.println("----------------------------------------");
				System.out.print("Enter the new Quantity: ");
				int qty=sc.nextInt();
				pst=con.prepareStatement("update orderdetails set qty=? where order_id=?");
				pst.setInt(1, qty);
				pst.setInt(2, Order_id);
				int row=pst.executeUpdate();
				if(row> 0) {
					System.out.println("Order quantity updated...");
				}else {
					System.out.println("error..");
				}
			}else {
	    		 System.out.println("order id doesnot exist..........");

			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	@Override
	public Order getOrderById(int Order_id) {
		try {
			pst=con.prepareStatement("select * from orderdetails where order_id=?");
			pst.setInt(1, Order_id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Order o=new Order();
				o.setOrder_id(rs.getInt(1));
				o.setCid(rs.getInt(2));
				o.setItem_id(rs.getInt(3));
				o.setQty(rs.getInt(4));
				o.setTotalcost(rs.getFloat(5));
				o.setOstatus(rs.getString(6));
				o.setPay_status(rs.getString(7));
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public void displayAllOrder() {
		try {
			rs=st.executeQuery("select * from orderdetails");
			System.out.println("--------------------------------");
			while(rs.next()) {
			System.out.println(rs.getInt(1)+"     "+rs.getInt(2)+"     "+rs.getInt(3)+"      "+rs.getInt(4)+"     " + rs.getFloat(5)+ "   " + rs.getString(6) + "   " + rs.getString(7) );
			}
			System.out.println("--------------------------------");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	

}
