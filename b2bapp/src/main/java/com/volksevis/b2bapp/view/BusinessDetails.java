package com.volksevis.b2bapp.view;

import java.util.List;

public class BusinessDetails {

	private String businessName;
	private String businessType;
	private String businessDescription;
	private List<TimeSlot> timeSlots;
	private List<WeekHoliday> weekHolidays;
	private List<Languages> langugaes;
	private String buisnessAddress;
	private String teamSize;
	private String businessStartYear;

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

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public List<WeekHoliday> getWeekHolidays() {
		return weekHolidays;
	}

	public void setWeekHolidays(List<WeekHoliday> weekHolidays) {
		this.weekHolidays = weekHolidays;
	}

	public List<Languages> getLangugaes() {
		return langugaes;
	}

	public void setLangugaes(List<Languages> langugaes) {
		this.langugaes = langugaes;
	}

	public String getBuisnessAddress() {
		return buisnessAddress;
	}

	public void setBuisnessAddress(String buisnessAddress) {
		this.buisnessAddress = buisnessAddress;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}

	public String getBusinessStartYear() {
		return businessStartYear;
	}

	public void setBusinessStartYear(String businessStartYear) {
		this.businessStartYear = businessStartYear;
	}

}
