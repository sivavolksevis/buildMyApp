package com.volksevis.b2bapp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.ServicesEntity;

@Repository
public interface ServicesRepository extends MongoRepository<ServicesEntity, Long> {

	public ServicesEntity findByCategoryId(Long category);

}
