package com.volksevis.b2bapp.exception;

public class MemberProfileException extends Exception {

	private static final long serialVersionUID = 7104550380941496506L;
	private String errorMessage;

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public MemberProfileException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public MemberProfileException() {
		super();
	}

}
