package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	double checkDeposite = 0.03;

	public double getCheckDeposite() {
		return checkDeposite;
	}

	public void setCheckDeposite(double checkDeposite) {
		this.checkDeposite = checkDeposite;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}

}
