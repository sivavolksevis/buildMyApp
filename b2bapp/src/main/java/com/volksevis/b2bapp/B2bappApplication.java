package com.volksevis.b2bapp;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.volksevis.b2bapp.exportDB.ExportCollectionsToDB;

@SpringBootApplication
public class B2bappApplication {

	public static void main(String[] args) throws IOException, JSONException {
		ApplicationContext applicationContext = SpringApplication.run(B2bappApplication.class, args);

		ExportCollectionsToDB exportCollectionsToDB = (ExportCollectionsToDB) applicationContext
				.getBean("exportCollectionsToDB");
		exportCollectionsToDB.exportServicesToDB();
	}

}
