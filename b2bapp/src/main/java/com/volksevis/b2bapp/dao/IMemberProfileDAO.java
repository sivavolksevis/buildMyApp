package com.volksevis.b2bapp.dao;

import com.volksevis.b2bapp.Model.MemberEntity;

public interface IMemberProfileDAO {

	/**
	 * @param memberEntity
	 */
	public void saveMemberEntityObject(MemberEntity memberEntity);

	/**
	 * @param mobile
	 * @return
	 */
	public MemberEntity findByMobileNumber(String mobile);

}
