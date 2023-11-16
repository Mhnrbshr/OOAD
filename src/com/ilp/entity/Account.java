package com.ilp.entity;

public class Account {
	
	private String accountNo;
	private double balance;
	private Product Product;
	
	
	public Account(String accountNo, double balance, Product product) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		Product = product;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	
	

}
