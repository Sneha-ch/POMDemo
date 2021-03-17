package testscripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HtmlUnitTest {
	
	WebDriver driver;
  
 
  @BeforeMethod
	public void beforeTest() {
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\Automation\\Selenium workshop\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com"); 
	}

	@Test(priority=3, enabled=false)
	public void searchJavaTest() {
//		WebElement searchBox = driver.findElement(By.name("q")); 
//		searchBox.sendKeys("Java Tutorial");
//		searchBox.submit();
//		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());			
		
		
		
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals("Google", driver.getTitle());
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		softAssert.assertEquals("Java Tutoria - Google Search", driver.getTitle());
		softAssert.assertAll();
	}

	@Test(priority=4, enabled=false)
	public void searchCucumberTest() {
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Cucumber Tutorial");
		searchBox.submit();
		Assert.assertEquals("Cucumber Tutorial - Google Search", driver.getTitle());
				
	}
	
	@Test(enabled=false, priority=2, alwaysRun=true, dependsOnMethods= {"searchJavaTest"})
	public void searchSeleniumTest() {
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();
		Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());
				
	}
	
	
	@Test
	public void searchAppiumTest() {
		System.out.println("Page Title: "+driver.getTitle());
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Appium Tutorial");
		searchBox.submit();
		Assert.assertEquals("Appium Tutorial - Google Search", driver.getTitle());
				
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
