package com.volksevis.b2bapp.service;

import org.json.JSONObject;

import com.volksevis.b2bapp.Model.PaymentDetails;

public interface IPaymentGatewayService {

	public JSONObject getAuthToken(PaymentDetails paymentDetails);

}
