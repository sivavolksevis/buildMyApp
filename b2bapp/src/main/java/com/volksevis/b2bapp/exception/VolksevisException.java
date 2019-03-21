package com.volksevis.b2bapp.exception;

public class VolksevisException extends Exception {

	private static final long serialVersionUID = -6219123870056324387L;

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

	public VolksevisException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public VolksevisException() {
		super();
	}
}
