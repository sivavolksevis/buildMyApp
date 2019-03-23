package com.volksevis.b2bapp.view;

import java.util.List;

public class BusinessDetails {

	private String businessName;
	private String businessType;
	private String businessDescription;
	private List<String> timeSlots;
	private List<String> weekHolidays;
	private List<String> langugaes;
	private String buisnessAddress;

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public List<String> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<String> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public List<String> getWeekHolidays() {
		return weekHolidays;
	}

	public void setWeekHolidays(List<String> weekHolidays) {
		this.weekHolidays = weekHolidays;
	}

	public List<String> getLangugaes() {
		return langugaes;
	}

	public void setLangugaes(List<String> langugaes) {
		this.langugaes = langugaes;
	}

	public String getBuisnessAddress() {
		return buisnessAddress;
	}

	public void setBuisnessAddress(String buisnessAddress) {
		this.buisnessAddress = buisnessAddress;
	}

}
