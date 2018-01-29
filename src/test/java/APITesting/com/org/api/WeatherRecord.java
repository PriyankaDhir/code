package APITesting.com.org.api;

import org.apache.commons.lang3.StringUtils;

/**
 * below class is to have variable to store needed values
 */
public class WeatherRecord {
	
	private String currentTemperature;
	private String feelsLike;
	private String weather;
	private String humidity;
	private String visibility;
	private String WindDir;
	
/**
 * 	Below constructor is created to assign values to created variables
 */
public WeatherRecord(String currentTemperature, String feelsLike, String weather, String humidity,
			String visibility, String WindDir) {
		super();
		this.currentTemperature = currentTemperature;
		this.feelsLike = feelsLike;
		this.weather = weather;
		this.humidity = humidity;
		this.visibility = visibility;
		this.WindDir = WindDir;
	}
	public String getCurrentTemperature() {
		return currentTemperature;
	}
	public void setCurrentTemperature(String currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	public String getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(String feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getWindDir() {
		return WindDir;
	}
	public void setWindDir(String WindDir) {
		this.WindDir = WindDir;
	}
	
	/**
	 * method to compare two objects
	 */
	public boolean equals(WeatherRecord w) {
		if(StringUtils.equalsIgnoreCase(this.currentTemperature, w.currentTemperature) &&
				StringUtils.equalsIgnoreCase(this.weather, w.weather) &&
				StringUtils.equalsIgnoreCase(this.feelsLike, w.feelsLike) &&
				StringUtils.equalsIgnoreCase(this.humidity, w.humidity) &&
				StringUtils.equalsIgnoreCase(this.visibility, w.visibility) &&
				StringUtils.equalsIgnoreCase(this.WindDir, w.WindDir))
			  return true;
		
		return false;
		
		
	}

}
