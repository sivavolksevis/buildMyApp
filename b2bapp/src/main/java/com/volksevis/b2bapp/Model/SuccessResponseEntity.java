package com.volksevis.b2bapp.Model;

import org.json.JSONObject;

public class SuccessResponseEntity {
	private boolean success;
	private int statusCode;
	private JSONObject response;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public JSONObject getResponse() {
		return response;
	}

	public void setResponse(JSONObject response) {
		this.response = response;
	}

}
