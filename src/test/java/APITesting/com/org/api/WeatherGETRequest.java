package APITesting.com.org.api;

import static com.jayway.restassured.RestAssured.*;

import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class WeatherGETRequest {
	@Parameters ({"apiKey","url"})
	
	@DataProvider(name = "CityAndState")
	public static Object[][] names(){
		return new Object[][] {{"WI","Madison"},{"WI","Milwaukee"}};
	}
	
	@Test(dataProvider = "CityAndState")
	public static  void Test_01(String apiKey,String State, String City,String url) {		
		WeatherRecord weatherRecordApi = new WeatherRecord(ApplicationUtil.getCurrentObservation(apiKey, State, "conditions", City, url, 
				"current_observation.temperature_string"),
				ApplicationUtil.getCurrentObservation(apiKey, State, "conditions", City, url, 
				"current_observation.feelslike_f"),
				 ApplicationUtil.getCurrentObservation(apiKey, State, "conditions", City, url, 
				"current_observation.weather"),
				ApplicationUtil.getCurrentObservation(apiKey, State, "conditions", City, url, 
				"current_observation.relative_humidity"),
				ApplicationUtil.getCurrentObservation(apiKey, State, "conditions",City, url, 
			    "current_observation.visibility_mi"),
				ApplicationUtil.getCurrentObservation(apiKey, State, "conditions", City, url, 
		         "current_observation.wind_dir"));
				
		
		WeatherRecord weatherRecordWebsite = ApplicationUtil.getData();
		
		boolean res = weatherRecordWebsite.equals(weatherRecordApi);
		
		Assert.assertEquals("true", res);				
	}
	
//	@Test
//	public static  void Test_02() {		
//		WeatherRecord weatherRecordApi = new WeatherRecord(ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "conditions", "Madison", "http://api.wunderground.com/api", 
//				"current_observation.temperature_string"),
//				ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "forecast10day", "Madison", "http://api.wunderground.com/api", 
//				"current_observation.feelslike_f"),
//				 ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "forecast10day", "Madison", "http://api.wunderground.com/api", 
//				"current_observation.weather"),
//				ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "forecast10day", "Madison", "http://api.wunderground.com/api", 
//				"current_observation.relative_humidity"),
//				ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "forecast10day","Madison", "http://api.wunderground.com/api", 
//			    "current_observation.visibility_mi"),
//				ApplicationUtil.getCurrentObservation("99a8db9a0f3c2e31", "WI", "forecast10day", "Madison", "http://api.wunderground.com/api", 
//		         "current_observation.wind_dir"));
//				
//		
//		WeatherRecord weatherRecordWebsite = ApplicationUtil.getData();
//		
//		boolean res = weatherRecordWebsite.equals(weatherRecordApi);
//		
//		Assert.assertEquals("true", res);
//	}

}
