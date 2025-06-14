 Feature: Validation place API's
 
 @AddPlace
 Scenario Outline: Verify if the place is being successfully added using AddplaceAPI
   Given add Place Payload with "<name>", "<Language>","<Address>"
   When user calls "AddPlaceAPI" with the "POST" http request
   Then the API call got success with status code 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   And verify place_Id created maps to "<name>" using "getPlaceAPI"
   
   
   Examples:
   
           |name |Language|Address|
           |Sarnith|tamil|XYZ|
  #         |Leela|English|ABC| 
  
  @DeletePlace 
  Scenario: Verify if Delete Place functionality is working
  
   Given DeletePlace Payload
   When user calls "deletePlaceAPI" with the "POST" http request
   Then the API call got success with status code 200
   And "status" in response body is "OK"
  
          