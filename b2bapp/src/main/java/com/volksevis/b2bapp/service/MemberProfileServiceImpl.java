package com.volksevis.b2bapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volksevis.b2bapp.dao.IMemberProfileDAO;

@Service
public class MemberProfileServiceImpl implements IMemberProfileService {

	@Autowired
	IMemberProfileDAO memberProfileDAO;
}
