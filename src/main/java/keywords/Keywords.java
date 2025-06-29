package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {
	WebDriver driver;

	public Keywords(WebDriver driver) {
		this.driver = driver;
	}
 
	public void click(String locatorType, String locatorValue) {
		driver.findElement(getBy(locatorType, locatorValue)).click();
	}

	public void enterText(String locatorType, String locatorValue, String testData) {
		driver.findElement(getBy(locatorType, locatorValue)).sendKeys(testData);
	}

	public By getBy(String locatorType, String locatorValue) {  // By is a object type
		switch (locatorType.toLowerCase()) {
			case "id": return By.id(locatorValue);
			case "name": return By.name(locatorValue);
			case "xpath": return By.xpath(locatorValue);
			case "css": return By.cssSelector(locatorValue);
			default: throw new IllegalArgumentException("Invalid locator type: " + locatorType);
		}
	}
}
