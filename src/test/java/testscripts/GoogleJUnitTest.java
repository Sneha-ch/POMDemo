package testscripts;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleJUnitTest {
	WebDriver driver;

	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\Selenium workshop\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com"); 
	}

	@Test
	public void test1() {

		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Java Tutorial");

		searchBox.submit();
		//assertEquals("Java tutorial - Google Search", 0);
		//Assert.assertEquals(false, false);
		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
		//			
	}

	@Test
	public void test2() {

		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Cucumber Tutorial");

		searchBox.submit();
		//assertEquals("Java tutorial - Google Search", 0);
		//Assert.assertEquals(false, false);
		Assert.assertEquals("Cucumber Tutorial - Google Search", driver.getTitle());
		//			
	}
	@After
	public void teardown() {
		driver.close();
	}

}
