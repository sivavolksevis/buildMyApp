package com.volksevis.b2bapp.Model;

import java.util.List;

public class ServiceDetails {

	private String serviceId;
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
