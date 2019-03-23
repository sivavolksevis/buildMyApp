package com.volksevis.b2bapp.service;

import org.json.JSONObject;

import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.exception.VolksevisException;
import com.volksevis.b2bapp.view.UserDetails;

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

	/**
	 * @return JSONObject
	 * @throws VolksevisException
	 */
	public JSONObject getServices() throws VolksevisException;

	/**
	 * @param userDetails
	 * @return JSONObject
	 * @throws VolksevisException
	 */
	public JSONObject saveMemberInfo(UserDetails userDetails) throws VolksevisException;

}
