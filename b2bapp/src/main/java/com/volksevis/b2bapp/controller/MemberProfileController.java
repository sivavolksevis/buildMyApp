package com.volksevis.b2bapp.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volksevis.b2bapp.exception.MemberProfileException;
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
		log.info("In memberRegistration method in" + this.getClass());
		JSONObject response = memberProfileService.memberRegistration(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

}
