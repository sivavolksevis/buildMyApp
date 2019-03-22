package com.volksevis.b2bapp.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volksevis.b2bapp.exception.MemberNotFoundException;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.exception.VolksevisException;
import com.volksevis.b2bapp.helper.MemberProfileHelper;
import com.volksevis.b2bapp.service.IMemberProfileService;

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
}
