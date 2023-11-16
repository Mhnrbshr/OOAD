package com.ilp.entity;

public class Service {
	
	private String serviceCode;
	private String serviceName;
	private double Rate;
	
	
	public Service(String serviceCode, String serviceName, double rate) {
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		Rate = rate;
	}
	
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	
	

}
