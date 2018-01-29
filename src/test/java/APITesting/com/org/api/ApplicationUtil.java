package APITesting.com.org.api;

import static com.jayway.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jayway.restassured.http.ContentType;

public class ApplicationUtil {

/**
 * 	below code uses rest-assured to hit api and GET the result for a specific city and state
 */
	public static String getCurrentObservation(String key, String state, String type, String city, String url, String path)
	{
		String result=given().
				param("Your_Key", key).
				param("State", state).
				param("City", city).
				when().
				get( url + "/" + key + "/" + type + "/q/" + state + "/" + city + ".json").
				then().
				contentType(ContentType.JSON).
				extract().
				path(path);
		
		System.out.println("Value of " + path + " is " + result);
		return result;
		
	}
	
	/**
	 * below code hit weather.com UI amd capture values against required properties
	 */
	public static WeatherRecord getData() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FNU\\Weather.com\\APICompareWithWeather\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.Weather.com");
		driver.manage().window().maximize();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver,50);		
		WebElement searchInputBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='theme__inputElement__4bZUj input-gvUyyzTM__inputElement__l7M9C']")));
		searchInputBox.sendKeys("Madison,WI");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'1262C')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[contains(.,'No items to display')]")));
		WebElement option = driver.findElement(By.xpath("//div[contains(@class,'1262C')]/following-sibling::ul/li[1]/a"));
		option.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//caption[contains(.,'Right Now')]")));
		String temperature = driver.findElement(By.xpath("//div[@class='today_nowcard-temp']//span")).getText();
		String feelsLike = driver.findElement(By.xpath("//span[@class='deg-feels']")).getText();
		String weather = driver.findElement(By.xpath("//div[@class='today_nowcard-phrase']")).getText();
		String humidity = driver.findElement(By.xpath("//th[contains(.,'Humidity')]/following-sibling::td/span/span")).getText();
		String visibility = driver.findElement(By.xpath("//th[contains(.,'Visibility')]/following-sibling::td/span")).getText();
		String WindDir =  ((driver.findElement(By.xpath("//th[contains(.,'Wind')]/following-sibling::td/span")).getText()).split(" "))[0];
		driver.close();
		System.out.println(temperature +feelsLike + weather + humidity + visibility +WindDir);
	 return  new WeatherRecord(temperature,feelsLike,weather,humidity,visibility,WindDir);	
	}	
}
