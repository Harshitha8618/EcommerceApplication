package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClassprogramme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");

		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// Open Google
		driver.get("https://www.google.com");

		// Find the search box using name locator
		WebElement searchBox = driver.findElement(By.name("q"));

		// Type 'Selenium' into the search box
		searchBox.sendKeys("Selenium");

		// Submit the search form
		searchBox.submit();

		// Wait for 3 seconds to view results
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.quit();
	}

}
