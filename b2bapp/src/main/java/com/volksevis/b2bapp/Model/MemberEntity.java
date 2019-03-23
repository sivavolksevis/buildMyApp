package com.volksevis.b2bapp.Model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
@Document(collection = "Members")
public class MemberEntity {

	@Id
	@Field(value = "_id")
	private Object id;
	@Field(value = "memberId")
	private long memberId;
	@Field(value = "mobileNumber")
	private String mobileNumber;
	@Field(value = "otp")
	private String otp;
	@Field(value = "firstName")
	private String firstName;
	@Field(value = "lastName")
	private String lastName;
	@Field(value = "active")
	private boolean active;
	private String stdCode;
	private String businessOwnerName;
	private String secondaryMobileNumber;
	private String landLineNumber;
	private String email;
	private String gender;
	private String qualification;
	private String otherQualifications;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBusinessOwnerName() {
		return businessOwnerName;
	}

	public void setBusinessOwnerName(String businessOwnerName) {
		this.businessOwnerName = businessOwnerName;
	}

	public String getSecondaryMobileNumber() {
		return secondaryMobileNumber;
	}

	public void setSecondaryMobileNumber(String secondaryMobileNumber) {
		this.secondaryMobileNumber = secondaryMobileNumber;
	}

	public String getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getOtherQualifications() {
		return otherQualifications;
	}

	public void setOtherQualifications(String otherQualifications) {
		this.otherQualifications = otherQualifications;
	}

	public String getStdCode() {
		return stdCode;
	}

	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

}
