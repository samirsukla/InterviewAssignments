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

public class SignUpTest extends BaseClass {
	GenerateRandomString gen;
	
  public SignUpTest() throws IOException {
		super();// Calling the baseclass constructor
		
	}

@SuppressWarnings("unchecked")
@Test
  public void doSignUp() {
	gen = new GenerateRandomString();
	userName = gen.getRandomString(10);
	try {
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		String requestBody = "{\"name\":\""+userName+"\",\"email\":\""+userName+prop.getProperty("emailId")+"\",\"password\":\""+prop.getProperty("password")+"\"}";
	
		Response resp = request.
			when().
			header("Content-Type", "application/json").
			body(requestBody).post("/sign-up");
	
		int statusCode = resp.getStatusCode();

		String respBody = resp.getBody().asString();
		tokenId = JsonPath.read(respBody, "$.token");
		System.out.println(tokenId);
	
		Assert.assertEquals(statusCode,200,"Sign Up API Failed");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
}
