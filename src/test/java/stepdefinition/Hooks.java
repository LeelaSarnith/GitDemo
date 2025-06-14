package stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	
	public void beforeScenario() throws IOException
	{
		
		
		stepdefinition m=new stepdefinition();
		
		if(stepdefinition.place_id==null)
		{
		m.add_place_payload_with("Mee", "hindi", "test");
		m.user_calls_with_the_http_request("AddPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Mee", "getPlaceAPI");
	}

}
}
