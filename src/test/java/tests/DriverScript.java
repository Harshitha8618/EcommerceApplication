package tests;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keywords.Keywords;
import utilities.ExcelReader;

public class DriverScript {
	
	@Test
	public void login() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/login");

		// Initialize keyword handler and Excel reader
		Keywords keywords = new Keywords(driver);
		ExcelReader reader = new ExcelReader("src/test/resources/testdata/TestData.xlsx");

		// Read data from sheet
		List<Map<String, String>> steps = reader.getTestData("Sheet1");

		for (Map<String, String> step : steps) {
			String keyword = step.get("Keyword");
			String locatorType = step.get("LocatorType");
			String locatorValue = step.get("LocatorValue");
			String testData = step.get("TestData");

			switch (keyword.toLowerCase()) {
				case "click":
					keywords.click(locatorType, locatorValue);
					break;
				case "entertext":
					keywords.enterText(locatorType, locatorValue, testData);
					break;
				default:
					System.out.println("Unsupported keyword: " + keyword);
			}
		}
		Thread.sleep(3000);  // just for demo viewing
		driver.quit();
	}
}
