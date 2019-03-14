package com.volksevis.b2bapp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.volksevis.b2bapp.Model.PaymentDetails;

@Service
public class PaymentGatewayServiceImpl implements IPaymentGatewayService {

	@Value("safaricom.consumerKey")
	private String consumerKey;

	@Value("safaricom.consumerSecret")
	private String consumerSecret;

	@Override
	public JSONObject getAuthToken(PaymentDetails paymentDetails) {

		return null;
	}

}
