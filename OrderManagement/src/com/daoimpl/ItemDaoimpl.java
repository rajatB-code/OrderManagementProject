package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Connect.DBConnection;
import com.dao.ItemDao;
import com.entity.Item;

public class ItemDaoimpl implements ItemDao{
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	static Scanner sc= new Scanner(System.in);
	
	public ItemDaoimpl()
	{
		con= DBConnection.getConnect();
		System.out.println("Connection done..............");
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void addItem() {
		System.out.println("Enter item id:");
		int iid= sc.nextInt();
		System.out.println("Enter item name:");
		String name= sc.next();
		System.out.println("Enter item cost:");
		float cost= sc.nextFloat();
		try
		{
			pst= con.prepareStatement("insert into item values(?,?,?)");
			pst.setInt(1, iid);
			pst.setString(2,name);
		    pst.setFloat(3, cost);
						
			int noOfRowsAdded= pst.executeUpdate();
			if(noOfRowsAdded>0)
			{
				System.out.println("Item added.............");
			}
			else
			{
				System.out.println("Error.........////////////");
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteItem(int id) {
		try {
			pst=con.prepareStatement("delete from item where item_id=?");
			pst.setInt(1, id);
			int row=pst.executeUpdate();
			if(row>=1) {
				System.out.println("deleted successfully..");
			}else {
				System.out.println("error..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateItem(int id) {
		try {
			Item i=new Item();
			i=getItemById(id);
			if(i!=null) {
				System.out.println("----item old details-----");
				System.out.println(i);
				System.out.println("-------------------------");
				System.out.print("Enter the new item name: ");
				String name=sc.next();
			
			pst=con.prepareStatement("update item set iname=? where item_id=?");
			pst.setString(1, name);
			pst.setInt(2, id);
			int row=pst.executeUpdate();
			if(row>=1) {
				System.out.println("item updated....");
			}else {
				System.out.println("error....");
			}
		}else {
	    		 System.out.println("item id doesnot exist.......");
	    	 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Item getItemById(int id) {
		try {
			pst=con.prepareStatement("select * from item where item_id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Item item=new Item();
				item.setItemid(rs.getInt(1));
				item.setIname(rs.getString(2));
				item.setCost(rs.getFloat(3));
				return item;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void displayAllItem() {
		try {
			rs=st.executeQuery("select * from item");
			System.out.println("----------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
				System.out.println("-------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
