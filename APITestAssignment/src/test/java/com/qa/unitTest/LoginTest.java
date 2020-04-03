package com.qa.unitTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.BaseClass;
import com.qa.utility.GenerateRandomString;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTest extends BaseClass {
	
	  public LoginTest() throws IOException {
			super();// Calling the baseclass constructor
			
		}

	@SuppressWarnings("unchecked")
	@Test
	  public void doLogin() {
		try {
			RestAssured.baseURI = baseURL;
			RequestSpecification request = RestAssured.given();
			
			String requestBody = "{\"email\":\""+userName+prop.getProperty("emailId")+"\",\"password\":\""+prop.getProperty("password")+"\"}";
		
			Response resp = request.
				when().
				header("Content-Type", "application/json").header("Authorization",tokenId).
				body(requestBody).post("/login");
		
			int statusCode = resp.getStatusCode();

			String respBody = resp.getBody().asString();
		
			Assert.assertEquals(statusCode,200,"Login API Failed");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  } 
}
