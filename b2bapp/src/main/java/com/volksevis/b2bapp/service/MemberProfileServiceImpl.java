package com.volksevis.b2bapp.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.controller.MemberProfileController;
import com.volksevis.b2bapp.dao.IMemberProfileDAO;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.util.ICommunicationUtility;

@Service
public class MemberProfileServiceImpl implements IMemberProfileService {

	private static final Logger log = LoggerFactory.getLogger(MemberProfileController.class);

	@Autowired
	IMemberProfileDAO memberProfileDAO;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ICommunicationUtility communicationUtility;

	@Override
	public JSONObject memberRegistration(String mobileNumber) throws MemberProfileException {
		log.info("In memberRegistration method in" + this.getClass());
		JSONObject responsObject = null;
		try {
			String otp = RandomStringUtils.randomNumeric(4);
			boolean isSMSsent = communicationUtility.sendTextMessage(mobileNumber, otp);
			if (!isSMSsent) {
				log.error("Failed to send OTP please try again");
				throw new MemberProfileException("Failed to send OTP please try again");
			}
			MemberEntity memberEntity = new MemberEntity();
			memberEntity.setMobileNumber(mobileNumber);
			memberEntity.setOtp(otp);
			memberProfileDAO.saveMemberEntityObject(memberEntity);
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("OTP", otp);
			responsObject.put("response", response);
		} catch (Exception exception) {
			log.error("MemberProfileException : " + exception.getMessage());
			throw new MemberProfileException(exception.getMessage());
		}
		return responsObject;
	}

}
