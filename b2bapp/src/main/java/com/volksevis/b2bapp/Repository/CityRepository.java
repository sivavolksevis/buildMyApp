package com.volksevis.b2bapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volksevis.b2bapp.Model.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
