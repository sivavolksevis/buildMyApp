package com.volksevis.b2bapp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volksevis.b2bapp.Model.CityEntity;
import com.volksevis.b2bapp.Model.DocumentDetails;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.Model.ServicesEntity;
import com.volksevis.b2bapp.controller.MemberProfileController;
import com.volksevis.b2bapp.dao.IMemberProfileDAO;
import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.exception.VolksevisException;
import com.volksevis.b2bapp.helper.B2bAppConstants;
import com.volksevis.b2bapp.util.ICommunicationUtility;
import com.volksevis.b2bapp.util.VolksevisUtility;
import com.volksevis.b2bapp.view.UserDetails;

@Service
public class MemberProfileServiceImpl implements IMemberProfileService {

	private static final Logger log = LoggerFactory.getLogger(MemberProfileController.class);

	@Autowired
	IMemberProfileDAO memberProfileDAO;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ICommunicationUtility communicationUtility;

	@Value("volksevis.otp.message")
	private String OTP_MESSAGE_BODY;

	@Value("${member.documents.path}")
	private String documentUploadPath;

	@Override
	public JSONObject memberRegistration(String mobileNumber) throws MemberProfileException {
		log.info("In memberRegistration method Started");
		JSONObject responsObject = null;
		try {
			String otp = RandomStringUtils.randomNumeric(4);
			String message = OTP_MESSAGE_BODY + otp;
			String formattedMobile = VolksevisUtility.formatIntoKenyaMobile(mobileNumber);
			boolean isSMSsent = communicationUtility.sendTextMessage(message, formattedMobile);
			if (!isSMSsent) {
				throw new MemberProfileException("Failed to send OTP please try again");
			}
			MemberEntity memberEntity = new MemberEntity();
			memberEntity.setMemberId(Long.valueOf(RandomStringUtils.randomNumeric(6)));
			memberEntity.setMobileNumber(mobileNumber);
			memberEntity.setOtp(otp);
			memberEntity.setStdCode(B2bAppConstants.KENYA_STD_CODE);
			memberProfileDAO.saveMemberEntityObject(memberEntity);
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("OTP", otp);
			response.put("memberId", memberEntity.getMemberId());
			responsObject.put("response", response);
		} catch (Exception exception) {
			throw new MemberProfileException(exception.getMessage());
		}
		log.info("In memberRegistration method Ended");
		return responsObject;
	}

	@Override
	public JSONObject validateOTP(String requestString) throws MemberNotFoundException {
		log.info("In validateOTP method Started");
		JSONObject responsObject = null;
		try {
			JSONObject requestObject = new JSONObject(requestString);
			String mobile = requestObject.getString("mobileNumber");
			String otp = requestObject.getString("otp");
			if (mobile != null) {
				MemberEntity memberEntity = memberProfileDAO.findByMobileNumber(mobile);
				if (otp != null && memberEntity != null && memberEntity.getOtp().equalsIgnoreCase(otp)) {
					responsObject = new JSONObject();
					responsObject.put("success", true);
					responsObject.put("statusCode", 200);
					JSONObject response = new JSONObject();
					response.put("message", "Valid Member");
					responsObject.put("response", response);
				} else {
					throw new MemberNotFoundException("Invalid OTP ");
				}
			} else {
				throw new MemberNotFoundException("Invalid Mobile  Number ");
			}
		} catch (Exception exception) {
			throw new MemberNotFoundException(exception.getMessage());
		}
		log.info("In validateOTP method Ended");
		return responsObject;
	}

	@Override
	public JSONObject getCities() throws MemberProfileException {
		log.info("In getCities method Started");
		JSONObject responsObject = null;
		try {
			List<CityEntity> cities = memberProfileDAO.getCities();
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("message", "Valid Member");
			String citiesString = objectMapper.writeValueAsString(cities);
			responsObject.put("response", new JSONArray(citiesString));
		} catch (Exception exception) {
			log.error("MemberProfileException : " + exception.getMessage());
			throw new MemberProfileException(exception.getMessage());
		}
		log.info("In getCities method Ended");
		return responsObject;
	}

	@Override
	public JSONObject getServices() throws VolksevisException {
		log.info("In getServices method Started");
		JSONObject responsObject = null;
		try {
			List<ServicesEntity> services = memberProfileDAO.getServices();
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("message", "Valid Request");
			String servicesString = objectMapper.writeValueAsString(services);
			responsObject.put("response", new JSONArray(servicesString));
		} catch (Exception exception) {
			throw new VolksevisException(exception.getMessage());
		}
		log.info("In getServices method Ended");
		return responsObject;
	}

	@Override
	public JSONObject saveMemberInfo(UserDetails userDetails) throws VolksevisException {
		log.info("In saveMemberInfo method Started");
		JSONObject responsObject = null;
		try {
			Long memberId = userDetails.getMemberId();
			MemberEntity memberEntity = memberProfileDAO.findByMemberId(memberId);
			if (memberEntity == null) {
				throw new VolksevisException("Invalid Request Details");
			}
			BeanUtils.copyProperties(userDetails, memberEntity, "memberId", "active");
			memberProfileDAO.saveMemberEntityObject(memberEntity);
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("message", "Valid Request");
			String member = objectMapper.writeValueAsString(memberEntity);
			responsObject.put("response", member);
		} catch (Exception exception) {
			throw new VolksevisException(exception.getMessage());
		}
		log.info("In saveMemberInfo method Ended");
		return responsObject;
	}

	@Override
	public JSONObject saveBusinessInfo(MemberEntity memberEntity) throws VolksevisException {
		log.info("In saveBusinessInfo method Started");
		JSONObject responsObject = null;
		try {
			Long memberId = memberEntity.getMemberId();
			MemberEntity persistedEntity = memberProfileDAO.findByMemberId(memberId);
			if (persistedEntity == null) {
				throw new VolksevisException("Invalid Request Details");
			}
			persistedEntity.setBusinessDetails(memberEntity.getBusinessDetails());
			memberProfileDAO.saveMemberEntityObject(persistedEntity);
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("message", "Valid Request");
			String member = objectMapper.writeValueAsString(persistedEntity);
			responsObject.put("response", new JSONObject(member));
		} catch (Exception exception) {
			throw new VolksevisException(exception.getMessage());
		}
		log.info("In saveBusinessInfo method Ended");
		return responsObject;
	}

	@Override
	public JSONObject uploadMemberAccountsAndDocuments(String memberDetails, MultipartFile[] uploadedFile)
			throws VolksevisException {
		log.info("In uploadMemberDocuments method Started");
		JSONObject responsObject = null;
		try {
			MemberAccountDetailsView memberAccountDetailsView = objectMapper.readValue(memberDetails,
					new TypeReference<MemberAccountDetailsView>() {
					});
			Long memberId = memberAccountDetailsView.getMemberId();
			List<String> filesList = uploadMemberDocuments(uploadedFile);
			saveDocumentDetails(filesList, memberId);
			MemberEntity memberEntity = memberProfileDAO.findByMemberId(memberId);
			if (memberEntity == null) {
				throw new VolksevisException("Invalid Request Details");
			}
			MemberAccountDetails memberAccountDetails = new MemberAccountDetails();
			BeanUtils.copyProperties(memberAccountDetailsView, memberAccountDetails);
			memberEntity.setMemberAccountDetails(memberAccountDetails);
			memberProfileDAO.saveMemberEntityObject(memberEntity);
			responsObject = new JSONObject();
			responsObject.put("success", true);
			responsObject.put("statusCode", 200);
			JSONObject response = new JSONObject();
			response.put("message", "Document Details Saved Succesfully");
			responsObject.put("message", response);
		} catch (Exception exception) {
			throw new VolksevisException(exception.getMessage());
		}
		log.info("In uploadMemberDocuments method Ended");
		return responsObject;
	}

	private void saveDocumentDetails(List<String> filesList, Long memberId) throws VolksevisException {
		log.info("In saveDocumentDetails method Started");
		if (filesList.isEmpty()) {
			throw new VolksevisException("Please upload Documents");
		}
		DocumentDetails persistedDocument = memberProfileDAO.findByMemberIdFromDocuments(memberId);
		if (persistedDocument == null) {
			persistedDocument = new DocumentDetails();
		}
		persistedDocument.setMemberId(memberId);
		for (String fileName : filesList) {
			if (fileName.contains("pass")) {
				persistedDocument.setPanCard(fileName);
			} else if (fileName.contains("id")) {
				persistedDocument.setIdCard(fileName);
			} else {
				persistedDocument.setBusinessRegistrationForm(fileName);
			}
		}
		memberProfileDAO.saveObject(persistedDocument);
		log.info("In saveDocumentDetails method Ended");
	}

	private List<String> uploadMemberDocuments(MultipartFile[] uploadedFile) throws IOException {
		log.info("In uploadMemberDocuments method Started");
		List<String> documentList = new ArrayList<>();
		List<MultipartFile> filesList = Arrays.asList(uploadedFile);
		for (MultipartFile multipartFile : filesList) {
			byte[] file = multipartFile.getBytes();
			String[] filename = multipartFile.getOriginalFilename().split("\\.");
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String generatedFileName = filename[0] + B2bAppConstants.UNDERSCORE + timeStamp + "." + filename[1];
			Path path = Paths.get(documentUploadPath + "//" + generatedFileName);
			Files.write(path, file);
			documentList.add(generatedFileName);
		}
		log.info("In uploadMemberDocuments method Ended");
		return documentList;
	}

}
