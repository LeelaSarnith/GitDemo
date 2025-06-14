package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.addPlaceDetails;
import pojo.locationClass;

public class TestDataBuild {
	
	public addPlaceDetails addPlacePayload(String name, String Language, String Address) {
		
		addPlaceDetails p=new addPlaceDetails();
		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(Language);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		locationClass lc= new locationClass();
		lc.setLat(-38.383494);
		lc.setlng(33.427362);
		p.setLocation(lc);
		return p;
		
	}

	public String deletePlacePayload(String place_id) {
		
		return " {\r\n"
				+ "        \"place_id\":\""+place_id+"\"\r\n"
				+ "    }";
		
	}

}
