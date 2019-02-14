package com.volksevis.b2bapp.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.volksevis.b2bapp.service.IMemberProfileService;

@Component
public class MemberProfileHelper {

	@Autowired
	IMemberProfileService memberProfileService;

}
