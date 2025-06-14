package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.TestDataBuild;
import resources.utils;


public class stepdefinition extends utils{
	ResponseSpecification Res;
	RequestSpecification res1;
	Response response;
	TestDataBuild data=new TestDataBuild();
    static String place_id;

	@Given("add Place Payload with {string}, {string},{string}")
	public void add_place_payload_with(String name, String Language, String Address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	
		
	  Res	=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		  res1 =given().spec(requestSpecification())
			.body(data.addPlacePayload(name, Language, Address));

	}
	@When("user calls {string} with the {string} http request")
	public void user_calls_with_the_http_request(String resources, String method)  {
	    // Write code here that turns the phrase above into concrete actions
		//Constructor will be called with value of resources which you pass
APIresources resourcesAPI=APIresources.valueOf(resources);
System.out.println(resourcesAPI.getResources());


if(method.equalsIgnoreCase("POST"))
	
response=res1.when().post(resourcesAPI.getResources());
			
	else if(method.equalsIgnoreCase("GET"))
	response=res1.when().get(resourcesAPI.getResources());

	}
	@Then("the API call got success with status code {int}")
	public void te_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	
assertEquals(getJsonPath(response, keyValue), Expectedvalue);

	
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resources) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	place_id=getJsonPath(response, "place_id");
	  res1 =given().spec(requestSpecification()).queryParam("place_id", place_id);
	  user_calls_with_the_http_request(resources, "GET");
	  String actualname=getJsonPath(response, "name");
	  assertEquals(actualname, expectedName);
	  
	  
	  }
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		res1=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	   
	}




	}
