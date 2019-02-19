package com.volksevis.b2bapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
	
	public MemberEntity findByMobileNumber(String mobile);

}
