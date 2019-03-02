package com.volksevis.b2bapp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.CityEntity;

@Repository
public interface CityRepository extends MongoRepository<CityEntity, Long> {

}
