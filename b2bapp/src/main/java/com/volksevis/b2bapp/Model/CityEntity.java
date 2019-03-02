package com.volksevis.b2bapp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY", schema = "VOLKSEVIS")
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITYID", nullable = false)
	private long cityId;
	@Column(name = "CITYNAME", nullable = false)
	private String cityName;
	@Column(name = "ACTIVE", nullable = false)
	private String active;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
