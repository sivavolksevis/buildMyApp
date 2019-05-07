package com.volksevis.b2bapp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.exception.VolksevisException;
import com.volksevis.b2bapp.helper.MemberProfileHelper;
import com.volksevis.b2bapp.service.IMemberProfileService;
import com.volksevis.b2bapp.view.SubServiceView;
import com.volksevis.b2bapp.view.UserDetails;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/volksevis/api/")
public class MemberProfileController {

	private static final Logger log = LoggerFactory.getLogger(MemberProfileController.class);

	@Autowired
	MemberProfileHelper memberProfileHelper;

	@Autowired
	IMemberProfileService memberProfileService;

	@PostMapping("/member-registration")
	public ResponseEntity<String> memberRegistration(@RequestBody(required = true) String mobileNumber)
			throws MemberProfileException {
		log.info("In memberRegistration method ");
		JSONObject response = memberProfileService.memberRegistration(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@PostMapping("/validateOTP")
	public ResponseEntity<String> validateOTP(@RequestBody(required = true) String requestObject)
			throws MemberProfileException, MemberNotFoundException {
		log.info("In validateOTP method ");
		JSONObject response = memberProfileService.validateOTP(requestObject);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@GetMapping("/getCities")
	public ResponseEntity<String> getCities() throws MemberProfileException {
		log.info("In getCities method ");
		JSONObject response = memberProfileService.getCities();
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@GetMapping("/getServices")
	public ResponseEntity<String> getServices() throws VolksevisException {
		log.info("In getServices method ");
		JSONObject response = memberProfileService.getServices();
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@PostMapping("/saveMemberInfo")
	public ResponseEntity<String> saveMemberInfo(@RequestBody UserDetails userDetails) throws VolksevisException {
		log.info("In saveMemberInfo method ");
		JSONObject response = memberProfileService.saveMemberInfo(userDetails);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@PostMapping("/saveBusinessInfo")
	public ResponseEntity<String> saveBusinessInfo(@RequestBody MemberEntity memberEntity) throws VolksevisException {
		log.info("In saveBusinessInfo method ");
		JSONObject response = memberProfileService.saveBusinessInfo(memberEntity);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@PostMapping(path = "/uploadMemberAccountsAndDocuments", consumes = "multipart/form-data")
	public ResponseEntity<String> uploadMemberAccountsAndDocuments(@RequestParam String businessAccountDetails,
			@RequestParam("uploadedFile") MultipartFile[] uploadedFile) throws VolksevisException {
		log.info("In uploadMemberAccountsAndDocuments  - Method Started");
		JSONObject response = memberProfileService.uploadMemberAccountsAndDocuments(businessAccountDetails,
				uploadedFile);
		log.info("In uploadMemberAccountsAndDocuments  - Method Ended");
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@PostMapping(path = "/saveSubService")
	public ResponseEntity<String> saveSubService(@RequestBody SubServiceView serviceView)
			throws JSONException, VolksevisException, MemberNotFoundException {
		log.info("In saveSubService  - Method Started");
		JSONObject response;
		try {
			response = memberProfileService.saveSubService(serviceView);
		} catch (JsonProcessingException exception) {
			throw new VolksevisException(exception.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

}
