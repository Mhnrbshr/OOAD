package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class AccountConfiguration {
	
	public static Customer createCustomer(ArrayList<Product> productList, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		
		System.out.print("Enter Customer Code");
		String customerCode = s.nextLine();
		System.out.println("Enter Customer Name");
		String customerName = s.nextLine();
		System.out.println("choose product you want to add");
		char choice;
		do {
			System.out.println("**********products available*********");
			
		for(Product product:productList)
		{
			System.out.println(product.getProductCode()+" "+product.getProductName());  //Printing services available
		    
		}
		
		System.out.println("enter the productcode ");
		String procode = s.nextLine();
		accountList.add(AccountConfiguration.createAccount(procode,productList));
		System.out.println("do you want to add more accnt(y/n)");
		choice=s.next().charAt(0);
		
		
		}while(choice=='y');
		return new Customer(customerCode,customerName,accountList);
	}
	private static Account createAccount(String procode,ArrayList<Product> productList) {
		Scanner s=new Scanner(System.in);
		Product choosedProduct=null;
		System.out.println("enter acntno");
		String accountNo=s.nextLine();
		System.out.println("enter acntbalnce");
	    double accountBalance=s.nextDouble();
		for(Product product:productList) {
			if(product.getProductCode().equals(procode)) {
				choosedProduct=product;
				break;
			}else {
				return null;
			}
		}
		return new Account(accountNo,accountBalance,choosedProduct);
	}
	public static void displayAccounts(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("*************customer accnt details**********");
		System.out.println("custmrid    cstmrname     acnttype     balnc");
		System.out.println("*********************************************");
		for(Account account:customer.getAccountList()){
			System.out.println(customer.getCustomerCode()+"  "+customer.getCustomerName()+"   "+account.getProduct().getProductName()+"    "+account.getBalance());
		}
		for(Account account:customer.getAccountList()) 
		{
			System.out.println("services for"+account.getProduct().getProductName());
			ArrayList<Service> selectedServiceList =account.getProduct().getServiceList();
			for(Service service:selectedServiceList) {
				System.out.println(service.getServiceName());
			}
		}
	}
	public static void transactionBill(Customer customer) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter the custmrcode");
		String customerCode= s.nextLine();
		System.out.println(customer.getCustomerName()+"has following accounts");
		for(Account account:customer.getAccountList()) {
			System.out.println((customer.getAccountList().indexOf(account)+1)+"."+account.getProduct().getProductName());
		}
		System.out.println("enter ur choice");
		int choice = s.nextInt();
		Account selectedAccount = customer.getAccountList().get(choice-1);
		System.out.println("choose the service you want");
		ArrayList<Service> selectedServiceList =selectedAccount.getProduct().getServiceList();
		for(Service service:selectedServiceList) {
			System.out.println((selectedServiceList.indexOf(service)+1)+"."+service.getServiceName());
		}
		System.out.println("choose the service");
		int choosedService = s.nextInt();
		System.out.println("enter the no of transactions");
		int trans = s.nextInt();
		double rate = selectedServiceList.get(choosedService-1).getRate();
		System.out.println("rate for transaction is"+(rate*trans));
	}
	
}
