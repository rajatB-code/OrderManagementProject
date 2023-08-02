package com.app;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.daoimpl.CustomerDaoimpl;
import com.entity.Customer;

public class CustomerPanel {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;
		do {
			System.out.println("-------------------Customer Panel-------------------------");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer Mobile no");
			System.out.println("4. Display Customer  ");
			System.out.println("5. Search Customer by id");
			System.out.println("6. Exit");

			CustomerDao cd = new CustomerDaoimpl();

			ch = sc.nextInt();
			Customer c = new Customer();
			switch (ch) {
			case 1:
				System.out.println("Enter the customer id:");
				c.setCid(sc.nextInt());
				System.out.println("Enter first name:");
				c.setFname(sc.next());
				System.out.println("Enter last name:");
				c.setLname(sc.next());
				System.out.println("Enter mobile no:");
				c.setMno(sc.nextLong());
				System.out.println("Enter email:");
				c.setEmail(sc.next());
				System.out.println("Enter address:");
				c.setAddress(sc.next());
				cd.addCustomer(c);

				break;

			case 2:
				System.out.println("Enter the customer id to be deleted:");
				int id = sc.nextInt();
				cd.deleteCustomer(id);
				break;
			case 3:
				System.out.println("Enter the customer id to be updated:");
				id = sc.nextInt();
				cd.updateCustomer(id);
				break;

			case 4:
				cd.displayAllCustomer();
				break;
			case 5:
				System.out.println("Enter the customer id to be displayed:");
				id = sc.nextInt();
				c = cd.getCustomerById(id);
				System.out.println("****************************************");
				if (c != null) {
					System.out.println(c);
				} else {
					System.out.println("No customer with this id exists...");
				}
				System.out.println("----------------------------------------------");
				break;
			case 6:
				MyApp.main(null);
				break;

			default:
				System.out.println("Wrong choice....");

			}
		} while (ch != 6);

	}

}
