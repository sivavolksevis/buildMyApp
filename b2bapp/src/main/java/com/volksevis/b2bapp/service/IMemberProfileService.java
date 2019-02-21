package com.volksevis.b2bapp.service;

import org.json.JSONObject;

import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;

public interface IMemberProfileService {

	/**
	 * @param mobileNumber
	 * @return JSONObject
	 * @throws MemberProfileException
	 */
	public JSONObject memberRegistration(String mobileNumber) throws MemberProfileException;

	/**
	 * @param requestObject
	 * @return
	 * @throws MemberProfileException
	 * @throws MemberNotFoundException
	 */
	public JSONObject validateOTP(String requestObject) throws MemberNotFoundException;

	/**
	 * @return JSONObject
	 * @throws MemberNotFoundException
	 */
	public JSONObject getCities() throws MemberProfileException;

}
