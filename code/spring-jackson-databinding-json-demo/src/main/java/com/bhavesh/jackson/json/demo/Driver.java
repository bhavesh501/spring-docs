package com.bhavesh.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("Fist name: " + theStudent.getFirstName());
			System.out.println("Last name: " + theStudent.getLastName());
			
			// print out address: street and city
			Address tempAddress = theStudent.getAddress();
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("Street = " + tempAddress.getCity());
			
			// print out the languages
			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
