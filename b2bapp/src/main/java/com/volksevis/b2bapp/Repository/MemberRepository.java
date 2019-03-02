package com.volksevis.b2bapp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.MemberEntity;

@Repository
public interface MemberRepository extends MongoRepository<MemberEntity, Long> {

	public MemberEntity findByMobileNumber(String mobile);

}
