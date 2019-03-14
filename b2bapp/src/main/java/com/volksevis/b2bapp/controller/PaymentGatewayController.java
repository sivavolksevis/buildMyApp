package com.volksevis.b2bapp.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.volksevis.b2bapp.Model.PaymentDetails;
import com.volksevis.b2bapp.exception.MemberProfileException;
import com.volksevis.b2bapp.service.IPaymentGatewayService;

@RestController
public class PaymentGatewayController {

	private static final Logger log = LoggerFactory.getLogger(PaymentGatewayController.class);

	@Autowired
	IPaymentGatewayService paymentGatewayServiceImpl;

	@PostMapping("/get-AUTH-TOKEN")
	public ResponseEntity<String> getAuthToken(@RequestBody(required = true) PaymentDetails paymentDetails)
			throws MemberProfileException {
		log.info("In getAuthToken method in" + this.getClass());
		JSONObject response = paymentGatewayServiceImpl.getAuthToken(paymentDetails);
		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}
}
