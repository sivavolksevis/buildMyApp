package com.volksevis.b2bapp.service;

public class MemberAccountDetails {

	private String accountNumber;
	private String IFSC;
	private String payeeName;
	private String referenceName;
	private String referenceMobile;
	private String referenceRelationship;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReferenceMobile() {
		return referenceMobile;
	}

	public void setReferenceMobile(String referenceMobile) {
		this.referenceMobile = referenceMobile;
	}

	public String getReferenceRelationship() {
		return referenceRelationship;
	}

	public void setReferenceRelationship(String referenceRelationship) {
		this.referenceRelationship = referenceRelationship;
	}

}
