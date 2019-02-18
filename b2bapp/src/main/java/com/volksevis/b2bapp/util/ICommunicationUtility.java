package com.volksevis.b2bapp.util;

public interface ICommunicationUtility {

	/**
	 * @param mobileNumber
	 * @param otp
	 * @return boolean
	 */
	public boolean sendTextMessage(String mobileNumber, String otp);
}
