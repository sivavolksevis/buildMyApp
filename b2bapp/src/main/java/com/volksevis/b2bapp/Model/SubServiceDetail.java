package com.volksevis.b2bapp.Model;

public class SubServiceDetail {

	private Long subServiceId;
	private String subServiceName;
	private String price;

	public String getSubServiceName() {
		return subServiceName;
	}

	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getSubServiceId() {
		return subServiceId;
	}

	public void setSubServiceId(Long subServiceId) {
		this.subServiceId = subServiceId;
	}

}
