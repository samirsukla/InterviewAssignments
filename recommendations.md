# Suggestions from My side
1. The response body should give proper information to the end user rather than just displaying a token value.(This is applicable for both APIs)
2.JSONObject is not working when trying to pass the payload as individual JSONObject. As the payload is simple and very less, It should be allowed in all the possible ways.
     Example Code : 
	JSONObject jobj = new JSONObject();

	jobj.put("name", "abcde"); 
	jobj.put("email","abcde@gmail.com");
	jobj.put("password", "abc123");
	request.body(jobj.toJSONString());

  This is applicable for both the APIs.
3.I believe,the status code for a success signup should be 201 instead of 200. There is no harm in response code 200. As it is creating a new entry in the server, 201 would have been better.
4.There is nothing to use from Signup API response in Login API request other than the token value. 
5.Login API is giving success response even with out using token Id from the Sign up API response.
