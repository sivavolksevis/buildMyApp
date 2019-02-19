package com.volksevis.b2bapp.service;

import org.json.JSONObject;

import com.volksevis.b2bapp.exception.MemberProfileException;

public interface IMemberProfileService {

	/**
	 * @param mobileNumber
	 * @return SuccessResponseEntity
	 * @throws MemberProfileException
	 */
	public JSONObject memberRegistration(String mobileNumber) throws MemberProfileException;

}
