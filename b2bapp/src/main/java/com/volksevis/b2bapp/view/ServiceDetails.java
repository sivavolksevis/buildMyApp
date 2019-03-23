package com.volksevis.b2bapp.view;

import java.util.List;

public class ServiceDetails {

	private Long serviceId;
	private String serviveName;
	private List<SubServiceDetail> subServices;

	public String getServiveName() {
		return serviveName;
	}

	public void setServiveName(String serviveName) {
		this.serviveName = serviveName;
	}

	public List<SubServiceDetail> getSubServices() {
		return subServices;
	}

	public void setSubServices(List<SubServiceDetail> subServices) {
		this.subServices = subServices;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

}
