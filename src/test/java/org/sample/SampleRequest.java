package org.sample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SampleRequest {
public static void main(String[] args) {
	System.out.println("=========GET=========");
	//way1 direct way
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	int code = res.getStatusCode();
	ResponseBody body = res.getBody();
	String sts = body.asString();
	System.out.println(code);
	System.out.println(body);
	System.out.println(sts);
	
	//way 2
	Response re = RestAssured.given().when().get("https://reqres.in/api/users?page=2");
	System.out.println(code);
	System.out.println(body);
	System.out.println(sts);
	
	//way3
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification given = RestAssured.given().header("Content-Type","application/json").queryParam("page", "2");
    Response resGet = given.when().get("api/users");
    System.out.println(resGet.getStatusCode());
    System.out.println(resGet.getBody().asString());
    
    System.out.println("=============POST==============");
    Response post = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
    		"    \"name\": \"morpheus\",\r\n" + 
    		"    \"job\": \"leader\"\r\n" + 
    		"}").when().post("api/users");
    System.out.println("Respose Code.........."+post.getStatusCode());
    System.out.println("Response Body..........."+post.getBody().asString());
    
    System.out.println("==============PUT==============");
    Response put = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
    		"    \"name\": \"morpheus\",\r\n" + 
    		"    \"job\": \"Manager\"\r\n" + 
    		"}").when().put("api/users/2");
    System.out.println("Respose Code.........."+put.getStatusCode());
    System.out.println("Response Body..........."+put.getBody().asString());
    
    System.out.println("============DELETE===========");
    Response delete = RestAssured.given().header("Content-Type","application/json").when().delete("api/users/2");
    System.out.println("Respose Code.........."+delete.getStatusCode());
    System.out.println("Response Body..........."+delete.getBody().asString());
    
   }
}
