package com.volksevis.b2bapp.exception;

public class MemberNotFoundException extends Exception {

	private static final long serialVersionUID = -7918814808529658069L;

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

	public MemberNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public MemberNotFoundException() {
		super();
	}
}
