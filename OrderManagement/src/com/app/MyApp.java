package com.app;

import java.util.Scanner;

public class MyApp {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		
		do
		{
			System.out.println("-----------Order Management System-------------");
			System.out.println("-----------------------------------------------");
			
			System.out.println("1. Item Panel");
			System.out.println("2. Customer Panel");
			System.out.println("3. Order Panel");
			System.out.println("4. Exit");
			
			System.out.println("Enter your Choice");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1: ItemPanel.main(null);
			        break;
			case 2: CustomerPanel.main(null);
			        break;
			case 3: OrderPanel.main(null);
			        break;
			case 4: System.exit(0);
			        break;
			default: System.out.println("error in input ");        
			
			}
		}
		while(ch!= 4);
		
	}

}
