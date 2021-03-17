package testscripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class DataParamTest {
	
	
	WebDriver driver;
	 @BeforeMethod
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\Selenium workshop\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://the-internet.herokuapp.com/login"); 
		}
	 
	@Parameters({"uname","pwd"})
	 //@Test(dataProvider="login_data")
  public void loginTest(String strName, String strPwd) {
		 System.out.println("strName: "+strName);
		 System.out.println("strPwd: "+strPwd);
	  driver.findElement(By.id("username")).sendKeys(strName);
	  driver.findElement(By.id("password")).sendKeys(strPwd);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  System.out.println(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());
		
				
	}
	 @DataProvider(name="login_data")
	 public Object[][] getData() {
		return new Object[][] {
		 new Object[] {"testuser1","welcome1"},
		 new Object[] {"testuser2","welcome2"},
		 new Object[] {"tomsmith","SuperSecretPassword!"},
	 };
	 } 
	 @AfterMethod
		public void teardown() {
			//driver.close();
		}
 
}
