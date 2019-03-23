package com.volksevis.b2bapp.util;

import org.springframework.stereotype.Component;

import com.volksevis.b2bapp.helper.B2bAppConstants;

@Component
public class VolksevisUtility {

	public static String formatIntoKenyaMobile(String mobileNumber) {
		return B2bAppConstants.KENYA_STD_CODE + mobileNumber;
	}

}
