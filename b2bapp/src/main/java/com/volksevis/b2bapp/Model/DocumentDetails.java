package com.volksevis.b2bapp.Model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
@Document(collection = "Documents")
public class DocumentDetails {

	@Id
	@Field(value = "_id")
	private Object id;
	private Long memberId;
	private String panCard;
	private String voterId;
	private String drivingLicense;
	private String aadharCard;
	private String cancelledCheque;
	private String bankPassbook;
	private String businessRegistrationForm;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getCancelledCheque() {
		return cancelledCheque;
	}

	public void setCancelledCheque(String cancelledCheque) {
		this.cancelledCheque = cancelledCheque;
	}

	public String getBankPassbook() {
		return bankPassbook;
	}

	public void setBankPassbook(String bankPassbook) {
		this.bankPassbook = bankPassbook;
	}

	public String getBusinessRegistrationForm() {
		return businessRegistrationForm;
	}

	public void setBusinessRegistrationForm(String businessRegistrationForm) {
		this.businessRegistrationForm = businessRegistrationForm;
	}

}
