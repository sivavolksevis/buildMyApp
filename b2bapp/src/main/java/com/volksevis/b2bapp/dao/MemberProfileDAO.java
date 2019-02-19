package com.volksevis.b2bapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.Repository.MemberRepository;

@Repository
public class MemberProfileDAO implements IMemberProfileDAO {

	@Autowired
	MemberRepository memberRepository;

	@Override
	public void saveMemberEntityObject(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
	}

}
