package com.volksevis.b2bapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.CityEntity;
import com.volksevis.b2bapp.Model.DocumentDetails;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.Model.ServicesEntity;
import com.volksevis.b2bapp.Repository.CityRepository;
import com.volksevis.b2bapp.Repository.MemberRepository;
import com.volksevis.b2bapp.Repository.ServicesRepository;

@Repository
public class MemberProfileDAO implements IMemberProfileDAO {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	ServicesRepository servicesRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveMemberEntityObject(MemberEntity memberEntity) {
		mongoTemplate.save(memberEntity);
	}

	@Override
	public MemberEntity findByMobileNumber(String mobile) {
		return memberRepository.findByMobileNumber(mobile);
	}

	@Override
	public List<CityEntity> getCities() {
		return cityRepository.findAll();
	}

	@Override
	public List<ServicesEntity> getServices() {
		return servicesRepository.findAll();
	}

	@Override
	public MemberEntity findByMemberId(long memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public void saveObject(DocumentDetails documentDetails) {
		mongoTemplate.save(documentDetails);
	}

	@Override
	public DocumentDetails findByMemberIdFromDocuments(Long memberId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("memberId").is(memberId));
		return mongoTemplate.findOne(query, DocumentDetails.class);
	}

}
