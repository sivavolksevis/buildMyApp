package com.volksevis.b2bapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volksevis.b2bapp.helper.MemberProfileHelper;

@RestController
@RequestMapping("/volksevis/api/")
public class MemberProfileController {

	@Autowired
	MemberProfileHelper memberProfileHelper;

}
