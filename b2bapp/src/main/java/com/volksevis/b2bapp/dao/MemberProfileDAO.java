package com.volksevis.b2bapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.CityEntity;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.Repository.CityRepository;
import com.volksevis.b2bapp.Repository.MemberRepository;

@Repository
public class MemberProfileDAO implements IMemberProfileDAO {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	CityRepository cityRepository;

	@Override
	public void saveMemberEntityObject(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
	}

	@Override
	public MemberEntity findByMobileNumber(String mobile) {
		return memberRepository.findByMobileNumber(mobile);
	}

	@Override
	public List<CityEntity> getCities() {
		return cityRepository.findAll();
	}

}
