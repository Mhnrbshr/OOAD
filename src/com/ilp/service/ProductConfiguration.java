package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductConfiguration {

	public static Service addService() {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("Choose the Services you want to add:");
		System.out.println(" enter any of this 1.Internet Banking\n2.Cash Withdrawal\n3.Cash Deposit\n4.ATM WIthdrawal\n5.Online Banking\n");
//		int choiceOfService = s.nextInt();
		System.out.println("enter servicecode");
		String serviceCode = s.nextLine();
		System.out.println("enter servicename");
		String serviceName = s.nextLine();
		System.out.println("enter servicerate");
		double rate  = s.nextDouble();
		s.nextLine();
		return new Service(serviceCode,serviceName,rate);
	}

	public static Product createProduct(ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList <Service> serviceListForProduct = new ArrayList<Service>();
		Product product = null;
		System.out.println("What products do you want to add:");
		System.out.println("1.Savings Max Account");
		System.out.println("2.Current Account");
		System.out.println("3.Loan Account");
		
		System.out.print("Enter Product Code");
		String productCode = s.nextLine();
		System.out.println("Enter Product Name");
		String productName = s.nextLine();
		
		char choice;
		do {
			System.out.println("choose service you want to add");
		for(Service service:serviceList)
			System.out.println(service.getServiceCode()+" "+service.getServiceName());  //printng services available
//		s.nextLine();
//		System.out.println("enter servccode you want to choose");
		String servccode = s.nextLine();
		
		for(Service service:serviceList) {
			if(service.getServiceCode().equals(servccode)) {
		       serviceListForProduct.add(service);
		break;
			}
		}
		System.out.println("do you want to add another service(y/n)");
		choice=s.next().charAt(0);
		}while(choice=='y');
			
		if(productName.equalsIgnoreCase("Savings Max Account")) {
			product =  new SavingsMaxAccount(productCode,productName,serviceListForProduct);
		}
		else if(productName.equalsIgnoreCase("Current Account")) {
			product =  new CurrentAccount(productCode,productName,serviceListForProduct);
		}
		else if(productName.equalsIgnoreCase("Loan Account")) {
			product =  new LoanAccount(productCode,productName,serviceListForProduct);
		}
		return product;
	}

}
