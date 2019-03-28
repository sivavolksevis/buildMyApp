package com.volksevis.b2bapp.exportDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volksevis.b2bapp.Model.ServicesEntity;

@Component("exportCollectionsToDB")
public class ExportCollectionsToDB {

	@Value("${volksevis.services}")
	private String servicesPath;

	/*
	 * @Value("${volksevis.cities}") private String citiesPath;
	 */

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	ObjectMapper objectMapper;

	public void exportServicesToDB() throws IOException, JSONException {
		JSONArray servicesArray = getJSONDatafromFile(servicesPath, "ServicesArray");
		List<ServicesEntity> jsonServicesList = objectMapper.readValue(servicesArray.toString(),
				new TypeReference<List<ServicesEntity>>() {
				});
		List<ServicesEntity> persistedServices = mongoTemplate.findAll(ServicesEntity.class);
		List<ServicesEntity> nonExistServices = jsonServicesList.stream()
				.filter(jsonService -> persistedServices.stream().noneMatch(
						dbServiceEntity -> dbServiceEntity.getCategoryName().equals(jsonService.getCategoryName())))
				.collect(Collectors.toList());
		for (ServicesEntity servicesEntity : nonExistServices) {
			mongoTemplate.save(servicesEntity);
		}

	}

	private JSONArray getJSONDatafromFile(String jsonFileName, String jsonArrayName) throws IOException, JSONException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStreamOfFile = classLoader.getResourceAsStream(jsonFileName);
		String jsonFileString = IOUtils.toString(inputStreamOfFile);
		JSONObject fileJSONObject = new JSONObject(jsonFileString);
		JSONArray resultantJsonArray = fileJSONObject.getJSONArray(jsonArrayName);
		return resultantJsonArray;
	}

}
