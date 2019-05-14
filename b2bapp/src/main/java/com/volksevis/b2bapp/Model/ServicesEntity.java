package com.volksevis.b2bapp.Model;

import java.util.List;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.volksevis.b2bapp.view.ServiceDetails;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
@Document(collection = "Services")
public class ServicesEntity {

	@Id
	@Field(value = "_id")
	private ObjectId id;
	private Long categoryId;
	private String categoryName;
	private List<ServiceDetails> services;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ServiceDetails> getServices() {
		return services;
	}

	public void setServices(List<ServiceDetails> services) {
		this.services = services;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
