package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
public static RequestSpecification Req;

	public RequestSpecification requestSpecification() throws IOException
	
	{
		
		if(Req==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
		
		Req	= new RequestSpecBuilder().
				setBaseUri(getGlobalValue("baseUri")).
				addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log)).
				setContentType(ContentType.JSON).build();
		return Req;
	}
		return Req;
	}
	public static String getGlobalValue (String key) throws IOException {
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
	return prop.getProperty(key);

	}
	
	public static String getJsonPath(Response response,String key)
	{
		String resp1= response.asString();
		JsonPath js1=new JsonPath(resp1);
	return	js1.get(key).toString();
	}
}
