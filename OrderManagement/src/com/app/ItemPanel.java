package com.app;

import java.util.Scanner;

import com.dao.ItemDao;
import com.daoimpl.ItemDaoimpl;
import com.entity.Item;

public class ItemPanel {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		do
		{
			System.out.println("-----------------Item Panel-------------------------");
			System.out.println("1. Add Item");
			System.out.println("2. Delete Item");
			System.out.println("3. Update Item cost");
			System.out.println("4. Display item cost ");
			System.out.println("5. Search item by id");
			System.out.println("6. Exit");
			
			ItemDao ido = new ItemDaoimpl();
			Item i = new Item();
			ch = sc.nextInt();
			switch(ch)
			{
			case 1: ido.addItem();
	        break;
	        
	case 2:
		System.out.print("Enter id we want to delete: ");
		int id=sc.nextInt();
		ido.deleteItem(id);
		break;
	case 3:
		System.out.print("Enter id we want to update: ");
		int id1=sc.nextInt();
		ido.updateItem(id1);
		break;
	case 4:
		ido.displayAllItem();
		break;
	case 5:
		System.out.print("Enter item id we want to search: ");
		int id2=sc.nextInt();
	
		i=ido.getItemById(id2);
		System.out.println("------------------------");
		if(i!=null)
	    {
	    	System.out.println(i);
	    }
	    else
	    {
	    	System.out.println("No item with this id exists.........");
	    }
	    System.out.println("---------------------------------------");
		break;
	case 6 : 
		MyApp.main(null);
		break;
	default: System.out.println("Wrong choice...........");         
	
	}
		}
    	while(ch!= 6);
		
	}

}
