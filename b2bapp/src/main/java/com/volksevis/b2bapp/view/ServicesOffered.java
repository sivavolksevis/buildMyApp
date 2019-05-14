package com.volksevis.b2bapp.view;

public class ServicesOffered {

	private Long categoryId;
	private Long serviceId;
	private SubServiceDetail subService;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public SubServiceDetail getSubService() {
		return subService;
	}

	public void setSubService(SubServiceDetail subService) {
		this.subService = subService;
	}

}
