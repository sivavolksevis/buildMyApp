package com.volksevis.b2bapp.dao;

import java.util.List;

import com.volksevis.b2bapp.Model.CityEntity;
import com.volksevis.b2bapp.Model.DocumentDetails;
import com.volksevis.b2bapp.Model.MemberEntity;
import com.volksevis.b2bapp.Model.ServicesEntity;

public interface IMemberProfileDAO {

	/**
	 * @param memberEntity
	 * @return
	 */
	public MemberEntity saveMemberEntityObject(MemberEntity memberEntity);

	/**
	 * @param mobile
	 * @return
	 */
	public MemberEntity findByMobileNumber(String mobile);

	/**
	 * @return List<CityEntity>
	 */
	public List<CityEntity> getCities();

	/**
	 * @return List<ServicesEntity>
	 */
	public List<ServicesEntity> getServices();

	/**
	 * @return MemberEntity
	 */
	public MemberEntity findByMemberId(long memberId);

	/**
	 * @param documentDetails
	 */
	public void saveObject(DocumentDetails documentDetails);

	/**
	 * @param memberId
	 * @return
	 */
	public DocumentDetails findByMemberIdFromDocuments(Long memberId);

}
