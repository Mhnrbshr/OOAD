package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ManageAccount {

	public static void manageAccount(Customer customer) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter custmr code");
		String customerCode = s.nextLine();
		System.out.println("you have followng acnts");
		for (Account account : customer.getAccountList()) {
			System.out.println(
					(customer.getAccountList().indexOf(account) + 1) + " " + account.getProduct().getProductName());
		}
		System.out.println("choose the acnt(index)");
		int choosedAccount = s.nextInt();
		Account selectedAccount = customer.getAccountList().get(choosedAccount - 1);
		System.out.println("select service you want(index)");
		System.out.println("1.Deposit Money 2.Withdraw Money 3.Display Balance");
		int choosedService = s.nextInt();
		switch (choosedService) {
		case 1:
			ManageAccount.depositMoney(selectedAccount);
			break;
		case 2:
			ManageAccount.withdrawMoney(selectedAccount);
			break;
		case 3:
			AccountConfiguration.displayAccounts(customer);
			break;
		}
	}

	private static void withdrawMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		SavingsMaxAccount savingsMaxAccount = null;
		double balance = selectedAccount.getBalance();

		double amount = 0;

		if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
			savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();
			double minBalance = savingsMaxAccount.getMinimumBalance();
			System.out.println("enter the amount to withdraw");
			amount = s.nextDouble();
			if ((balance - amount) < minBalance) {

				while ((balance - amount) < minBalance) {
					System.out.println("can't withdraw the money, should have min 1000 balnc");
					System.out.println("enter lesser amnt");
					amount = s.nextDouble();
				}
			} 
			balance = balance - amount;
			selectedAccount.setBalance(balance);

		} else {
			System.out.println("enter the amount to withdraw");
			amount = s.nextDouble();
			balance = selectedAccount.getBalance();
			balance = balance - amount;
			selectedAccount.setBalance(balance);
		}
	}

	private static void depositMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		double balance = selectedAccount.getBalance();
//		if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
//			SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();
//			double minBalance = savingsMaxAccount.getMinimumBalance();
//			System.out.println("enter the amount to be deposited");
//			double amount = s.nextDouble();
//			if (amount < minBalance) {
//				while (amount < minBalance) {
//					System.out.println("you have to deposite min 1000");
//					System.out.println("enter the greatr amount");
//					amount = s.nextDouble();
//				}
//			} else {
//				balance = balance + amount;
//				selectedAccount.setBalance(balance);
//			}
//		}

		LoanAccount loanAccount = null;
		if (selectedAccount.getProduct() instanceof LoanAccount) {
			loanAccount = (LoanAccount) selectedAccount.getProduct();
			double check = loanAccount.getCheckDeposite();
			System.out.println("1.on the counter 2.cheque deposit");
			System.out.println("choose the option");
			int choice = s.nextInt();
			double amount;
			switch (choice) {
			case 1:
				System.out.println("enter the amount to be deposited");
				amount = s.nextDouble();
				balance = balance + amount;
				selectedAccount.setBalance(balance);
				break;
			case 2:
				System.out.println("enter the amount to be deposited");
				amount = s.nextDouble();
				balance = balance + amount;
				balance = balance - (balance * check);
				selectedAccount.setBalance(balance);
				break;
			}
		} else {
			double amount;
			System.out.println("enter the amount to be deposited");
			amount = s.nextDouble();
			balance = balance + amount;
			selectedAccount.setBalance(balance);
		}
	}

}
