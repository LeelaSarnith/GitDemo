package resources;

public enum APIresources {
	
	//enum is a special class in java which has collection of constants or method
	
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");

	private String resources;

	APIresources(String resources) {
		// TODO Auto-generated constructor stub
		
		this.resources=resources;
	}
	
	public String getResources() {
		
		return resources;
		
	}
	

}
