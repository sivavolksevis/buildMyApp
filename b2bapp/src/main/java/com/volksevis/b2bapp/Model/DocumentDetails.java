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
	private String passport;
	private String idCard;
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
		return passport;
	}

	public void setPanCard(String panCard) {
		this.passport = panCard;
	}

	public String getBusinessRegistrationForm() {
		return businessRegistrationForm;
	}

	public void setBusinessRegistrationForm(String businessRegistrationForm) {
		this.businessRegistrationForm = businessRegistrationForm;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
