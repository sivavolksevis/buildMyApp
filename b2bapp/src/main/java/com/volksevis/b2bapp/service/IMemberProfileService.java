package com.volksevis.b2bapp.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.exception.VolksevisException;
import com.volksevis.b2bapp.view.SubServiceView;
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

	/**
	 * @param memberEntity
	 * @return JSONObject
	 * @throws VolksevisException
	 */
	public JSONObject saveBusinessInfo(MemberEntity memberEntity) throws VolksevisException;

	/**
	 * @param businessAccountDetails
	 * @param uploadedFile
	 * @return
	 * @throws VolksevisException
	 */
	public JSONObject uploadMemberAccountsAndDocuments(String businessAccountDetails, MultipartFile[] uploadedFile)
			throws VolksevisException;

	/**
	 * @param serviceView
	 * @return JSONObject
	 * @throws JSONException
	 * @throws VolksevisException
	 * @throws MemberNotFoundException
	 * @throws JsonProcessingException
	 */
	public JSONObject saveSubService(SubServiceView serviceView)
			throws JSONException, VolksevisException, MemberNotFoundException, JsonProcessingException;

	/**
	 * @param serviceView
	 * @return
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public JSONObject deleteSubService(SubServiceView serviceView) throws JSONException, JsonProcessingException;

	/**
	 * @param memberId
	 * @return JSONObject
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public JSONObject getMemberDetails(long memberId) throws JSONException, JsonProcessingException;

}
